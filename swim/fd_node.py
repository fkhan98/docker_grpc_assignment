#!/usr/bin/env python3

import argparse
import threading
import time
import grpc
import random
import json
import os

import swim_pb2
import swim_pb2_grpc
from concurrent import futures

DATA_DIR = "./data"
os.makedirs(DATA_DIR, exist_ok=True)

class FailureDetectorServicer(swim_pb2_grpc.FailureDetectorServicer):
    def __init__(self, node_id, membership_list):
        self.node_id = node_id
        self.membership_list = membership_list
        self.last_heard_from = {}

    def Ping(self, request, context):
        print(f"Component FailureDetector of Node {self.node_id} "
              f"runs RPC Ping called by Component FailureDetector of Node {request.sender_id}")
        return swim_pb2.PingAck(ack=True)

    def IndirectPing(self, request, context):
        print(f"Component FailureDetector of Node {self.node_id} "
              f"runs RPC IndirectPing to Node {request.target_id} called by "
              f"Component FailureDetector of Node {request.sender_id}")
        try:
            with grpc.insecure_channel(f'localhost:{request.target_id}') as channel:
                stub = swim_pb2_grpc.FailureDetectorStub(channel)
                response = stub.Ping(swim_pb2.PingRequest(sender_id=self.node_id))
                return swim_pb2.IndirectPingAck(target_id=request.target_id, ack=response.ack)
        except grpc.RpcError:
            return swim_pb2.IndirectPingAck(target_id=request.target_id, ack=False)
    
    def RemoveFailedNode(self, request, context):
        """Handles NotifyFailure by removing the failed node from membership list."""
        failed_node_id = request.failed_node_id

        if failed_node_id in self.membership_list:
            self.membership_list.remove(failed_node_id)
            print(f"Component FailureDetector of Node {self.node_id} removed failed Node {failed_node_id} from membership list.")
        else:
            print(f"Component FailureDetector of Node {self.node_id} received NotifyFailure for {failed_node_id}, but it was not found in the membership list.")

        return swim_pb2.FailedNodeRemovedAck(ack=True)
    
    def JoinNewNode(self, request, context):
        new_node_id = request.new_node_id

        if new_node_id not in self.membership_list:
            self.membership_list.append(new_node_id)
            print(f"Component FailureDetector of Node {self.node_id} added new Node {new_node_id} to membership list.")
        else:
            print(f"Component FailureDetector of Node {self.node_id} received New Node Join notification for {new_node_id}, but it was already found in the membership list.")

        return swim_pb2.NewNodeJoinAck(ack=True)
        

    def monitor_nodes(self):
        """Continuously monitor other nodes in the membership list."""
        time.sleep(30)  # Initial delay
        while True:
            if not self.membership_list:
                time.sleep(5)
                continue

            target = random.choice(self.membership_list)
            print(f"Component FailureDetector of Node {self.node_id} sends RPC Ping "
                  f"to Component FailureDetector of Node {target}")

            try:
                time.sleep(60)
                with grpc.insecure_channel(f'localhost:{target}') as channel:
                    stub = swim_pb2_grpc.FailureDetectorStub(channel)
                    response = stub.Ping(swim_pb2.PingRequest(sender_id=self.node_id), timeout=5)
                    if response.ack:
                        self.last_heard_from[target] = time.time()
                        json_path = os.path.join(DATA_DIR, f"{self.node_id}_last_heard_from.json")
                        with open(json_path, "w") as f:
                            json.dump(self.last_heard_from, f, indent=4)
                        continue
            except grpc.RpcError:
                pass

            # Try Indirect Pings
            other_nodes = [n for n in self.membership_list if n != target]
            selected_nodes = random.sample(other_nodes, min(3, len(other_nodes)))
            for node in selected_nodes:
                print(f"Component FailureDetector of Node {self.node_id} sends RPC IndirectPing "
                      f"to Component FailureDetector of Node {node}")
                try:
                    with grpc.insecure_channel(f'localhost:{node}') as channel:
                        stub = swim_pb2_grpc.FailureDetectorStub(channel)
                        response = stub.IndirectPing(
                            swim_pb2.IndirectPingRequest(
                                sender_id=self.node_id, 
                                target_id=target
                            ),
                            timeout=5
                        )
                        if response.ack:
                            self.last_heard_from[target] = time.time()
                            json_path = os.path.join(DATA_DIR, f"{self.node_id}_last_heard_from.json")
                            with open(json_path, "w") as f:
                                json.dump(self.last_heard_from, f, indent=4)
                            break
                except grpc.RpcError:
                    pass
            else:
                print(f"Node {target} marked as failed by Node {self.node_id}")
                self.notify_failure_to_dissemination(target)
            time.sleep(60)
        
    def notify_failure_to_dissemination(self, failed_node_id):
        """Notifies the Java Dissemination service about the failed node."""
        try:
            # Map Failure Detector port (500XX) to its corresponding Dissemination Server (600XX)
            dissemination_port = int(self.node_id) + 10000  # Maps 50051 → 60051, 50052 → 60052, etc.
            dissemination_failed_node = int(failed_node_id) + 10000

            print(f"Component FailureDetector of Node {self.node_id} notifies  Component Dissemination at {dissemination_port} about failure of Node {failed_node_id}")

            with grpc.insecure_channel(f'localhost:{dissemination_port}') as channel:
                stub = swim_pb2_grpc.DisseminationStub(channel)

                request = swim_pb2.NotifyFailureRequest(
                    sender_id=str(self.node_id),
                    failed_node_id=str(dissemination_failed_node)
                )

                response = stub.NotifyFailure(request)
                if response.ack:
                    print(f"Java Dissemination acknowledged failure of Node {failed_node_id}")
                else:
                    print(f"Java Dissemination did not acknowledge failure of Node {failed_node_id}")

        except grpc.RpcError as e:
            print(f"Error notifying Java Dissemination: {e}")


def serve(port, membership):
    """Start the Failure Detector service on the given port, with an initial membership list."""
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    fd_servicer = FailureDetectorServicer(node_id=port, membership_list=membership)
    swim_pb2_grpc.add_FailureDetectorServicer_to_server(fd_servicer, server)

    server.add_insecure_port(f'[::]:{port}')
    server.start()
    print(f"Failure Detector Server started at port {port}")

    # Start the monitoring thread
    monitor_thread = threading.Thread(target=fd_servicer.monitor_nodes)
    monitor_thread.start()

    server.wait_for_termination()


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--port", default="50051", help="Port to run the Failure Detector service.")
    parser.add_argument("--membership", nargs="*", default=[], 
                        help="List of known node ports in the membership.")
    args = parser.parse_args()

    serve(args.port, args.membership)
