import grpc
import failure_detection_pb2
import failure_detection_pb2_grpc
import random
import time

def run_client(node_id, target_id, target_port):
    channel = grpc.insecure_channel(f'localhost:{target_port}')
    stub = failure_detection_pb2_grpc.FailureDetectorStub(channel)
    
    print(f"Component FailureDetector of Node {node_id} sends RPC Ping to Component FailureDetector of Node {target_id}")
    response = stub.Ping(failure_detection_pb2.PingRequest(sender_id=node_id))
    print(f"Received response: {response.success}")

if __name__ == "__main__":
    nodes = [("1", "2", 50051)]
    time.sleep(2)  # Allow servers to start
    for node_id, target_id, target_port in nodes:
        run_client(node_id, target_id, target_port)