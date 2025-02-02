package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class JavaClient {

    public static void main(String[] args) {
        // Create a channel to communicate with the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext() // No TLS (for development)
                .build();

        // Create a stub (client)
        MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);

        // Create a request message
        ServiceProto.RequestMessage request = ServiceProto.RequestMessage.newBuilder()
                .setName("Java Client")
                .build();

        // Send the request and receive the response
        try {
            ServiceProto.ResponseMessage response = stub.getResponse(request);
            System.out.println("Java Client received: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }

        // Shutdown the channel
        channel.shutdown();
    }
}
