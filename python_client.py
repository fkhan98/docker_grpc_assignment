import grpc
import service_pb2
import service_pb2_grpc

def run():
    channel = grpc.insecure_channel("localhost:50052")
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
    # print("Python Client received weather updates:", response2.update)

if __name__ == "__main__":
    run()
