import grpc
import service_pb2
import service_pb2_grpc
import time

def run():
    channel = grpc.insecure_channel("python-server:50051")
    stub = service_pb2_grpc.MyServiceStub(channel)
    
    request1 = service_pb2.RequestMessage(name="Python Client")
    response1 = stub.GetResponse(request1)
    print("Python Client received:", response1.message)


    request2 = service_pb2.WeatherRequest(city="Arlington, Texas")
    responses = stub.GetWeatherUpdates(request2)
    #Synchronous (Blocking Call)
    #CLients waits till getting all reponses and then prints all the response
    for response2 in responses:
        print(f"Weather update: {response2.update}")
    
    print('---------------------------------------------------------------')
    
    java_channel = grpc.insecure_channel("java-server:50052")
    java_stub = service_pb2_grpc.MyServiceStub(java_channel)
    
    request1 = service_pb2.RequestMessage(name="Python Client")
    response1 = java_stub.GetResponse(request1)
    print("Python Client received:", response1.message)


    request2 = service_pb2.WeatherRequest(city="Arlington, Texas")
    responses = java_stub.GetWeatherUpdates(request2)
    #Synchronous (Blocking Call)
    #CLients waits till getting all reponses and then prints all the response
    for response2 in responses:
        print(f"Weather update: {response2.update}")
    # print("Python Client received weather updates:", response2.update)

if __name__ == "__main__":
    run()
