import grpc
import time
from concurrent import futures
import service_pb2
import service_pb2_grpc


from datetime import datetime, timedelta
from meteostat import Point, Daily
from geopy.geocoders import Nominatim

def get_avg_temp(lat, long):
    
    today = datetime.today()

    # Create Point for Arlington, TX
    location = Point(lat, long, 70)


    # Get daily data for 2018
    data = Daily(location, today- timedelta(days=2), today)
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
        tavg = get_avg_temp(lat,long)
       

        weather_response = (
            f"Latitude and Longitude for {request.city} is {lat},{long} "
            f"and Average temperature is {tavg}"
        )
        
        # weather_reponse = f"Lattitude and Longitude for  {request.city} is {lat_str},{long_str} and Average temperature is {tavg_str}"
        
        
        yield service_pb2.WeatherResponse(update=weather_response)
        
    

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    service_pb2_grpc.add_MyServiceServicer_to_server(MyServiceServicer(), server)
    server.add_insecure_port("[::]:50051")
    server.start()
    print("Python Server is running on port 50051...")
    server.wait_for_termination()

if __name__ == "__main__":
    serve()
