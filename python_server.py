import grpc
import time
from concurrent import futures
import service_pb2
import service_pb2_grpc

class MyServiceServicer(service_pb2_grpc.MyServiceServicer):
    def GetResponse(self, request, context):
        response = f"Hello {request.name}, this is Python Server!"
        return service_pb2.ResponseMessage(message=response)

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    service_pb2_grpc.add_MyServiceServicer_to_server(MyServiceServicer(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Python Server is running on port 50051...")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
