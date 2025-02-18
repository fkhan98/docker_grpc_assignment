from concurrent import futures
import json
import grpc
import failure_detection_pb2
import failure_detection_pb2_grpc
import time
import random
import threading
import os

stop_event = threading.Event()

DATA_DIR = "./data"
os.makedirs(DATA_DIR, exist_ok=True)

class FailureDetectorServicer(failure_detection_pb2_grpc.FailureDetectorServicer):
    def __init__(self, node_id,membership_list):
        self.node_id = node_id
        self.membership_list = membership_list  # List of other nodes
        self.last_heard_from = {}
        
    def Ping(self, request, context):
        print(f"Component FailureDetector of Node {self.node_id} runs RPC Ping called by Component FailureDetector of Node {request.sender_id}")
        return failure_detection_pb2.PingAck(ack=True)

    def IndirectPing(self, request, context):
        print(f"Component FailureDetector of Node {self.node_id} runs RPC IndirectPing to Node {request.target_id} called by Component FailureDetector of Node {request.sender_id}")
        try:
            with grpc.insecure_channel(f'node{request.target_id[-1]}:{request.target_id}') as channel:
                stub = failure_detection_pb2_grpc.FailureDetectorStub(channel)
                response = stub.Ping(failure_detection_pb2.PingRequest(node_id=self.node_id))
                return failure_detection_pb2.IndirectPingAck(target_id = request.target_id, ack=response.ack)
        except grpc.RpcError:
            return failure_detection_pb2.IndirectPingAck(target_id = request.target_id, ack=False)
        
    def monitor_nodes(self):
        time.sleep(30)
        while True:
            # if not self.membership_list:
            #     time.sleep(5)
            #     continue

            target = random.choice(self.membership_list)
            print(f"Component FailureDetector of Node {self.node_id} sends RPC Ping to Component FailureDetector of Node {target}")

            try:
                with grpc.insecure_channel(f'node{target[-1]}:{target}') as channel:
                    stub = failure_detection_pb2_grpc.FailureDetectorStub(channel)
                    response = stub.Ping(failure_detection_pb2.PingRequest(sender_id=self.node_id),timeout=5)
                    if response.ack:
                        self.last_heard_from[target] = time.time()
                        json_path = os.path.join(DATA_DIR, f"{self.node_id}_last_heard_from.json")
                        with open(json_path, "w") as f:
                            json.dump(self.last_heard_from, f, indent=4)
                        # time.sleep(T_PRIME)
                        continue
            except grpc.RpcError:
                pass

            # Indirect Ping
            other_nodes = [n for n in self.membership_list if n != target]
            selected_nodes = random.sample(other_nodes, min(3, len(other_nodes)))
            for node in selected_nodes:
                print(f"Component FailureDetector of Node {self.node_id} sends RPC IndirectPing to Component FailureDetector of Node {node}")
                try:
                    with grpc.insecure_channel(f'node{node[-1]}:{node}') as channel:
                        stub = failure_detection_pb2_grpc.FailureDetectorStub(channel)
                        response = stub.IndirectPing(failure_detection_pb2.IndirectPingRequest(sender_id=self.node_id, target_id=target), timeout=5)
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

            time.sleep(5)

def serve(port,node_id):
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    membership_list = ["50051","50053","50054","50055"]
    
    failure_detection_pb2_grpc.add_FailureDetectorServicer_to_server(FailureDetectorServicer(node_id = port, membership_list=membership_list), server)
    server.add_insecure_port(f'[::]:{port}')
    server.start()
    print(f"Server started at port {port} (Node {node_id})")
    
    failure_detection = FailureDetectorServicer(node_id = port,membership_list=membership_list)
    failure_detection.monitor_nodes()

    server.wait_for_termination()

if __name__ == "__main__":
    serve("50052",2)
  
        