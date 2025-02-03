

from datetime import datetime, timedelta
from meteostat import Point, Daily

# Set time period
# start = datetime(2025, 1, 1)
# end = datetime(2025,1,2)
# today = datetime.today()

# # Create Point for Vancouver, BC
# location = Point(32.7357, -97.1081, 70)


# # Get daily data for 2018
# data = Daily(location, today- timedelta(days=2), today)
# data = data.fetch()

# print(data.tavg)
from geopy.geocoders import Nominatim

def get_lat_long(city_name):
    geolocator = Nominatim(user_agent="weather_app")
    location = geolocator.geocode(city_name)
    
    if location:
        return location.latitude, location.longitude
    else:
        return None, None

# Example usage
city = "Arlington, Texas"
latitude, longitude = get_lat_long(city)
if latitude and longitude:
    print(f"The latitude and longitude of {city} are {latitude}, {longitude}")
else:
    print(f"Could not find the coordinates for {city}")