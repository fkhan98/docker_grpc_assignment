import grpc
import time
from concurrent import futures
import service_pb2
import service_pb2_grpc


from datetime import datetime, timedelta
from meteostat import Point, Daily
from geopy.geocoders import Nominatim

def get_avg_temp(lat, long, day):
    
    today = datetime.today()

    # Create Point for Arlington, TX
    location = Point(lat, long, 70)


    # Get daily data for 2018
    data = Daily(location, day- timedelta(days=1), day)
    data = data.fetch()
    return data.tavg

def get_lat_long(city_name):
    geolocator = Nominatim(user_agent="weather_app")
    location = geolocator.geocode(city_name)
    
    if location:
        return location.latitude, location.longitude
    else:
        return None, None


class MyServiceServicer(service_pb2_grpc.MyServiceServicer):
    def GetResponse(self, request, context):
        response = f"Hello {request.name}, this is Python Server!"
        return service_pb2.ResponseMessage(message=response)
    
    def GetWeatherUpdates(self, request, context):
       
        lat,long = get_lat_long(request.city)
        today = datetime.today() 
        for i in range(3):
            tavg = get_avg_temp(lat,long, today-timedelta(days=i))
       
            
            weather_response = (
                f"Latitude and Longitude for {request.city} is {lat},{long} "
                f"and Average temperature for {tavg.index[0].date()} is {tavg.iloc[0]}"
            )
        
            
            yield service_pb2.WeatherResponse(update=weather_response)
            time.sleep(1)
        
    

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    service_pb2_grpc.add_MyServiceServicer_to_server(MyServiceServicer(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Python Server is running on port 50051...")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
