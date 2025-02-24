package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.Optional;

public class JavaClient {

    public static void main(String[] args) {
        String javaServerHost = Optional.ofNullable(System.getenv("JAVA_GRPC_SERVER_HOST"))
                .orElse("localhost")
                .trim();  

        System.out.println("Connecting to Java gRPC Server at: [" + javaServerHost + "] on port 50052");


        ManagedChannel channel = ManagedChannelBuilder.forAddress(javaServerHost, 50052)
                .usePlaintext()  // No TLS (plaintext communication)
                .build();

        // Create stubs
        MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);
        MyServiceGrpc.MyServiceStub asyncStub = MyServiceGrpc.newStub(channel);

        callGetResponse(stub);
        callGetWeatherUpdatesNonBlocking(asyncStub, "Arlington, Texas");

        System.out.println("---------------------------------------------------------------");

        String pythonServerHost = Optional.ofNullable(System.getenv("PYTHON_GRPC_SERVER_HOST"))
                .orElse("localhost")
                .trim();

        System.out.println("Connecting to Python gRPC Server at: [" + pythonServerHost + "] on port 50051");

        ManagedChannel python_channel = ManagedChannelBuilder.forAddress(pythonServerHost, 50051)
                .usePlaintext()  // No TLS (plaintext communication)
                .build();  

        MyServiceGrpc.MyServiceBlockingStub pythonStub = MyServiceGrpc.newBlockingStub(python_channel);
        MyServiceGrpc.MyServiceStub pythonAsyncStub = MyServiceGrpc.newStub(python_channel);

        callGetResponse(pythonStub);
        // callGetWeatherUpdatesNonBlocking(pythonAsyncStub, "Arlington, Texas");
        callGetWeatherUpdatesBlocking(pythonStub, "Arlington, Texas");

        try {
            channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // logger.severe("Channel shutdown was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
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
