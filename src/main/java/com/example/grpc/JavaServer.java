package com.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

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
    }
}
