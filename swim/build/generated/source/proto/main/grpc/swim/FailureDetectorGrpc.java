package swim;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Failure Detector Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: swim.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FailureDetectorGrpc {

  private FailureDetectorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "swim.FailureDetector";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<swim.PingRequest,
      swim.PingAck> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = swim.PingRequest.class,
      responseType = swim.PingAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<swim.PingRequest,
      swim.PingAck> getPingMethod() {
    io.grpc.MethodDescriptor<swim.PingRequest, swim.PingAck> getPingMethod;
    if ((getPingMethod = FailureDetectorGrpc.getPingMethod) == null) {
      synchronized (FailureDetectorGrpc.class) {
        if ((getPingMethod = FailureDetectorGrpc.getPingMethod) == null) {
          FailureDetectorGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<swim.PingRequest, swim.PingAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.PingAck.getDefaultInstance()))
              .setSchemaDescriptor(new FailureDetectorMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<swim.IndirectPingRequest,
      swim.IndirectPingAck> getIndirectPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IndirectPing",
      requestType = swim.IndirectPingRequest.class,
      responseType = swim.IndirectPingAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<swim.IndirectPingRequest,
      swim.IndirectPingAck> getIndirectPingMethod() {
    io.grpc.MethodDescriptor<swim.IndirectPingRequest, swim.IndirectPingAck> getIndirectPingMethod;
    if ((getIndirectPingMethod = FailureDetectorGrpc.getIndirectPingMethod) == null) {
      synchronized (FailureDetectorGrpc.class) {
        if ((getIndirectPingMethod = FailureDetectorGrpc.getIndirectPingMethod) == null) {
          FailureDetectorGrpc.getIndirectPingMethod = getIndirectPingMethod =
              io.grpc.MethodDescriptor.<swim.IndirectPingRequest, swim.IndirectPingAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IndirectPing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.IndirectPingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.IndirectPingAck.getDefaultInstance()))
              .setSchemaDescriptor(new FailureDetectorMethodDescriptorSupplier("IndirectPing"))
              .build();
        }
      }
    }
    return getIndirectPingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FailureDetectorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FailureDetectorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FailureDetectorStub>() {
        @java.lang.Override
        public FailureDetectorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FailureDetectorStub(channel, callOptions);
        }
      };
    return FailureDetectorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FailureDetectorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FailureDetectorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FailureDetectorBlockingStub>() {
        @java.lang.Override
        public FailureDetectorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FailureDetectorBlockingStub(channel, callOptions);
        }
      };
    return FailureDetectorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FailureDetectorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FailureDetectorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FailureDetectorFutureStub>() {
        @java.lang.Override
        public FailureDetectorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FailureDetectorFutureStub(channel, callOptions);
        }
      };
    return FailureDetectorFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Failure Detector Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void ping(swim.PingRequest request,
        io.grpc.stub.StreamObserver<swim.PingAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     */
    default void indirectPing(swim.IndirectPingRequest request,
        io.grpc.stub.StreamObserver<swim.IndirectPingAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIndirectPingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FailureDetector.
   * <pre>
   * Failure Detector Service
   * </pre>
   */
  public static abstract class FailureDetectorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FailureDetectorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FailureDetector.
   * <pre>
   * Failure Detector Service
   * </pre>
   */
  public static final class FailureDetectorStub
      extends io.grpc.stub.AbstractAsyncStub<FailureDetectorStub> {
    private FailureDetectorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FailureDetectorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FailureDetectorStub(channel, callOptions);
    }

    /**
     */
    public void ping(swim.PingRequest request,
        io.grpc.stub.StreamObserver<swim.PingAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void indirectPing(swim.IndirectPingRequest request,
        io.grpc.stub.StreamObserver<swim.IndirectPingAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIndirectPingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FailureDetector.
   * <pre>
   * Failure Detector Service
   * </pre>
   */
  public static final class FailureDetectorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FailureDetectorBlockingStub> {
    private FailureDetectorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FailureDetectorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FailureDetectorBlockingStub(channel, callOptions);
    }

    /**
     */
    public swim.PingAck ping(swim.PingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     */
    public swim.IndirectPingAck indirectPing(swim.IndirectPingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIndirectPingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FailureDetector.
   * <pre>
   * Failure Detector Service
   * </pre>
   */
  public static final class FailureDetectorFutureStub
      extends io.grpc.stub.AbstractFutureStub<FailureDetectorFutureStub> {
    private FailureDetectorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FailureDetectorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FailureDetectorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<swim.PingAck> ping(
        swim.PingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<swim.IndirectPingAck> indirectPing(
        swim.IndirectPingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIndirectPingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_INDIRECT_PING = 1;

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
        case METHODID_PING:
          serviceImpl.ping((swim.PingRequest) request,
              (io.grpc.stub.StreamObserver<swim.PingAck>) responseObserver);
          break;
        case METHODID_INDIRECT_PING:
          serviceImpl.indirectPing((swim.IndirectPingRequest) request,
              (io.grpc.stub.StreamObserver<swim.IndirectPingAck>) responseObserver);
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
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              swim.PingRequest,
              swim.PingAck>(
                service, METHODID_PING)))
        .addMethod(
          getIndirectPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              swim.IndirectPingRequest,
              swim.IndirectPingAck>(
                service, METHODID_INDIRECT_PING)))
        .build();
  }

  private static abstract class FailureDetectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FailureDetectorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return swim.Swim.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FailureDetector");
    }
  }

  private static final class FailureDetectorFileDescriptorSupplier
      extends FailureDetectorBaseDescriptorSupplier {
    FailureDetectorFileDescriptorSupplier() {}
  }

  private static final class FailureDetectorMethodDescriptorSupplier
      extends FailureDetectorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FailureDetectorMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FailureDetectorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FailureDetectorFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getIndirectPingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
