package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

public class JavaClient {

    public static void main(String[] args) {
        // Create a channel to communicate with the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext() // No TLS (for development)
                .build();

        // Create a stub (client)
        // MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);
        MyServiceGrpc.MyServiceStub asyncStub = MyServiceGrpc.newStub(channel);

        // callGetResponse(stub);

        // callGetWeatherUpdatesBlocking(stub, "Arlington, Texas");

        callGetWeatherUpdatesNonBlocking(asyncStub, "Arlington, Texas");

        try {
            channel.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Client interrupted while waiting for responses.");
            Thread.currentThread().interrupt(); // Restore interrupted state
        }
    }

    private static void callGetResponse(MyServiceGrpc.MyServiceBlockingStub stub) {
        System.out.println("Calling GetResponse...");
        ServiceProto.RequestMessage request = ServiceProto.RequestMessage.newBuilder()
                .setName("Java Client")
                .build();

        try {
            ServiceProto.ResponseMessage response = stub.getResponse(request);
            System.out.println("Java Client received: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    private static void callGetWeatherUpdatesNonBlocking(MyServiceGrpc.MyServiceStub stub, String city) {
        System.out.println("Calling GetWeatherUpdates for city: " + city);

        ServiceProto.WeatherRequest request = ServiceProto.WeatherRequest.newBuilder()
                .setCity(city)
                .build();
        System.out.println("request: " + request);
        stub.getWeatherUpdates(request, new StreamObserver<ServiceProto.WeatherResponse>() {
            @Override
            public void onNext(ServiceProto.WeatherResponse response) {
                System.out.println("Weather update: " + response.getUpdate());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error receiving weather updates: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Weather updates stream completed.");
            }
        });
    }

    private static void callGetWeatherUpdatesBlocking(MyServiceGrpc.MyServiceBlockingStub stub, String city) {
        System.out.println("Calling GetWeatherUpdates for city: " + city);

        ServiceProto.WeatherRequest request = ServiceProto.WeatherRequest.newBuilder()
                .setCity(city)
                .build();

        try {
            // Call the streaming RPC and get an iterator for the responses
            Iterator<ServiceProto.WeatherResponse> responses = stub.getWeatherUpdates(request);

            // Iterate through the stream until the server finishes sending responses
            while (responses.hasNext()) {
                System.out.println("Weather update: " + responses.next().getUpdate());
            }

            System.out.println("Weather updates stream completed.");

        } catch (StatusRuntimeException e) {
            System.err.println("Error receiving weather updates: " + e.getStatus());
        }
    }
}
