package com.example.grpc;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import com.example.grpc.WeatherEntry;

public class JavaServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new MyServiceImpl())
                .build()
                .start();

        System.out.println("Java Server is running on port 50052...");
        server.awaitTermination();
    }

    static class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {
        @Override
        public void getResponse(ServiceProto.RequestMessage request,
                                StreamObserver<ServiceProto.ResponseMessage> responseObserver) {
            String responseMessage = "Hello " + request.getName() + ", this is Java Server!";
            ServiceProto.ResponseMessage response = ServiceProto.ResponseMessage.newBuilder()
                    .setMessage(responseMessage)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void getWeatherUpdates(ServiceProto.WeatherRequest request,
                                    StreamObserver<ServiceProto.WeatherResponse> responseObserver) {
            String city = request.getCity();
            System.out.println("Received weather updates request for city: " + city);

            // Path to the local JSON file
            File file = new File("weather_data.json");

            try {
                // Use Jackson to read the JSON as a nested map: Map<City, Map<Date, WeatherEntry>>
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Map<String, WeatherEntry>> weatherMap = objectMapper.readValue(
                        file,
                        new TypeReference<Map<String, Map<String, WeatherEntry>>>() {}
                );

                // Check if the requested city exists in the JSON data
                if (!weatherMap.containsKey(city)) {
                    System.out.println("City not found: " + city);
                    responseObserver.onError(new RuntimeException("No weather data available for " + city));
                    return;
                }

                // Retrieve the date-wise weather entries for the requested city
                Map<String, WeatherEntry> cityWeatherData = weatherMap.get(city);

                // Iterate over the available dates for that city
                for (Map.Entry<String, WeatherEntry> entry : cityWeatherData.entrySet()) {
                    String date = entry.getKey();
                    WeatherEntry weatherEntry = entry.getValue();

                    // Construct a formatted update message
                    String updateMessage = String.format(
                            "Date: %s | City: %s | Lat: %.4f | Lon: %.4f | AvgTemp: %.1f°C",
                            date, city, weatherEntry.latitude, weatherEntry.longitude, weatherEntry.avg_temperature
                    );

                    // Build and send the WeatherResponse
                    ServiceProto.WeatherResponse response = ServiceProto.WeatherResponse.newBuilder()
                            .setUpdate(updateMessage)
                            .build();

                    responseObserver.onNext(response);
                }

            } catch (IOException e) {
                e.printStackTrace();
                responseObserver.onError(e);
                return;
            }

            // Indicate the end of the streaming response
            responseObserver.onCompleted();
        }
    }
}