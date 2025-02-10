package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Define the gRPC Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MyServiceGrpc {

  private MyServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "grpc_example.MyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.RequestMessage,
      com.example.grpc.ServiceProto.ResponseMessage> getGetResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResponse",
      requestType = com.example.grpc.ServiceProto.RequestMessage.class,
      responseType = com.example.grpc.ServiceProto.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.RequestMessage,
      com.example.grpc.ServiceProto.ResponseMessage> getGetResponseMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.RequestMessage, com.example.grpc.ServiceProto.ResponseMessage> getGetResponseMethod;
    if ((getGetResponseMethod = MyServiceGrpc.getGetResponseMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getGetResponseMethod = MyServiceGrpc.getGetResponseMethod) == null) {
          MyServiceGrpc.getGetResponseMethod = getGetResponseMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ServiceProto.RequestMessage, com.example.grpc.ServiceProto.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ServiceProto.RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ServiceProto.ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("GetResponse"))
              .build();
        }
      }
    }
    return getGetResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.WeatherRequest,
      com.example.grpc.ServiceProto.WeatherResponse> getGetWeatherUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherUpdates",
      requestType = com.example.grpc.ServiceProto.WeatherRequest.class,
      responseType = com.example.grpc.ServiceProto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.WeatherRequest,
      com.example.grpc.ServiceProto.WeatherResponse> getGetWeatherUpdatesMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.ServiceProto.WeatherRequest, com.example.grpc.ServiceProto.WeatherResponse> getGetWeatherUpdatesMethod;
    if ((getGetWeatherUpdatesMethod = MyServiceGrpc.getGetWeatherUpdatesMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getGetWeatherUpdatesMethod = MyServiceGrpc.getGetWeatherUpdatesMethod) == null) {
          MyServiceGrpc.getGetWeatherUpdatesMethod = getGetWeatherUpdatesMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.ServiceProto.WeatherRequest, com.example.grpc.ServiceProto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ServiceProto.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.ServiceProto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("GetWeatherUpdates"))
              .build();
        }
      }
    }
    return getGetWeatherUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceStub>() {
        @java.lang.Override
        public MyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceStub(channel, callOptions);
        }
      };
    return MyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub>() {
        @java.lang.Override
        public MyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceBlockingStub(channel, callOptions);
        }
      };
    return MyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub>() {
        @java.lang.Override
        public MyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceFutureStub(channel, callOptions);
        }
      };
    return MyServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Define the gRPC Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getResponse(com.example.grpc.ServiceProto.RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResponseMethod(), responseObserver);
    }

    /**
     */
    default void getWeatherUpdates(com.example.grpc.ServiceProto.WeatherRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherUpdatesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MyService.
   * <pre>
   * Define the gRPC Service
   * </pre>
   */
  public static abstract class MyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MyService.
   * <pre>
   * Define the gRPC Service
   * </pre>
   */
  public static final class MyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MyServiceStub> {
    private MyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceStub(channel, callOptions);
    }

    /**
     */
    public void getResponse(com.example.grpc.ServiceProto.RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResponseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWeatherUpdates(com.example.grpc.ServiceProto.WeatherRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MyService.
   * <pre>
   * Define the gRPC Service
   * </pre>
   */
  public static final class MyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MyServiceBlockingStub> {
    private MyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.ServiceProto.ResponseMessage getResponse(com.example.grpc.ServiceProto.RequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResponseMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.ServiceProto.WeatherResponse> getWeatherUpdates(
        com.example.grpc.ServiceProto.WeatherRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MyService.
   * <pre>
   * Define the gRPC Service
   * </pre>
   */
  public static final class MyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MyServiceFutureStub> {
    private MyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.ServiceProto.ResponseMessage> getResponse(
        com.example.grpc.ServiceProto.RequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESPONSE = 0;
  private static final int METHODID_GET_WEATHER_UPDATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESPONSE:
          serviceImpl.getResponse((com.example.grpc.ServiceProto.RequestMessage) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.ResponseMessage>) responseObserver);
          break;
        case METHODID_GET_WEATHER_UPDATES:
          serviceImpl.getWeatherUpdates((com.example.grpc.ServiceProto.WeatherRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.ServiceProto.WeatherResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetResponseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.grpc.ServiceProto.RequestMessage,
              com.example.grpc.ServiceProto.ResponseMessage>(
                service, METHODID_GET_RESPONSE)))
        .addMethod(
          getGetWeatherUpdatesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.grpc.ServiceProto.WeatherRequest,
              com.example.grpc.ServiceProto.WeatherResponse>(
                service, METHODID_GET_WEATHER_UPDATES)))
        .build();
  }

  private static abstract class MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MyService");
    }
  }

  private static final class MyServiceFileDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier {
    MyServiceFileDescriptorSupplier() {}
  }

  private static final class MyServiceMethodDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MyServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MyServiceFileDescriptorSupplier())
              .addMethod(getGetResponseMethod())
              .addMethod(getGetWeatherUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
