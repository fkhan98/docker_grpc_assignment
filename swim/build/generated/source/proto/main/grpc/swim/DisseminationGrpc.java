package swim;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Dissemination Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: swim.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DisseminationGrpc {

  private DisseminationGrpc() {}

  public static final java.lang.String SERVICE_NAME = "swim.Dissemination";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<swim.NotifyFailureRequest,
      swim.NotifyFailureAck> getNotifyFailureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NotifyFailure",
      requestType = swim.NotifyFailureRequest.class,
      responseType = swim.NotifyFailureAck.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<swim.NotifyFailureRequest,
      swim.NotifyFailureAck> getNotifyFailureMethod() {
    io.grpc.MethodDescriptor<swim.NotifyFailureRequest, swim.NotifyFailureAck> getNotifyFailureMethod;
    if ((getNotifyFailureMethod = DisseminationGrpc.getNotifyFailureMethod) == null) {
      synchronized (DisseminationGrpc.class) {
        if ((getNotifyFailureMethod = DisseminationGrpc.getNotifyFailureMethod) == null) {
          DisseminationGrpc.getNotifyFailureMethod = getNotifyFailureMethod =
              io.grpc.MethodDescriptor.<swim.NotifyFailureRequest, swim.NotifyFailureAck>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NotifyFailure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.NotifyFailureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.NotifyFailureAck.getDefaultInstance()))
              .setSchemaDescriptor(new DisseminationMethodDescriptorSupplier("NotifyFailure"))
              .build();
        }
      }
    }
    return getNotifyFailureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<swim.JoinRequest,
      swim.JoinResponse> getJoinMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Join",
      requestType = swim.JoinRequest.class,
      responseType = swim.JoinResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<swim.JoinRequest,
      swim.JoinResponse> getJoinMethod() {
    io.grpc.MethodDescriptor<swim.JoinRequest, swim.JoinResponse> getJoinMethod;
    if ((getJoinMethod = DisseminationGrpc.getJoinMethod) == null) {
      synchronized (DisseminationGrpc.class) {
        if ((getJoinMethod = DisseminationGrpc.getJoinMethod) == null) {
          DisseminationGrpc.getJoinMethod = getJoinMethod =
              io.grpc.MethodDescriptor.<swim.JoinRequest, swim.JoinResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Join"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.JoinRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  swim.JoinResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DisseminationMethodDescriptorSupplier("Join"))
              .build();
        }
      }
    }
    return getJoinMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DisseminationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationStub>() {
        @java.lang.Override
        public DisseminationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationStub(channel, callOptions);
        }
      };
    return DisseminationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DisseminationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationBlockingStub>() {
        @java.lang.Override
        public DisseminationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationBlockingStub(channel, callOptions);
        }
      };
    return DisseminationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DisseminationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DisseminationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DisseminationFutureStub>() {
        @java.lang.Override
        public DisseminationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DisseminationFutureStub(channel, callOptions);
        }
      };
    return DisseminationFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Dissemination Service
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void notifyFailure(swim.NotifyFailureRequest request,
        io.grpc.stub.StreamObserver<swim.NotifyFailureAck> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNotifyFailureMethod(), responseObserver);
    }

    /**
     */
    default void join(swim.JoinRequest request,
        io.grpc.stub.StreamObserver<swim.JoinResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Dissemination.
   * <pre>
   * Dissemination Service
   * </pre>
   */
  public static abstract class DisseminationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DisseminationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Dissemination.
   * <pre>
   * Dissemination Service
   * </pre>
   */
  public static final class DisseminationStub
      extends io.grpc.stub.AbstractAsyncStub<DisseminationStub> {
    private DisseminationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationStub(channel, callOptions);
    }

    /**
     */
    public void notifyFailure(swim.NotifyFailureRequest request,
        io.grpc.stub.StreamObserver<swim.NotifyFailureAck> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNotifyFailureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void join(swim.JoinRequest request,
        io.grpc.stub.StreamObserver<swim.JoinResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Dissemination.
   * <pre>
   * Dissemination Service
   * </pre>
   */
  public static final class DisseminationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DisseminationBlockingStub> {
    private DisseminationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationBlockingStub(channel, callOptions);
    }

    /**
     */
    public swim.NotifyFailureAck notifyFailure(swim.NotifyFailureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNotifyFailureMethod(), getCallOptions(), request);
    }

    /**
     */
    public swim.JoinResponse join(swim.JoinRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Dissemination.
   * <pre>
   * Dissemination Service
   * </pre>
   */
  public static final class DisseminationFutureStub
      extends io.grpc.stub.AbstractFutureStub<DisseminationFutureStub> {
    private DisseminationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DisseminationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DisseminationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<swim.NotifyFailureAck> notifyFailure(
        swim.NotifyFailureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNotifyFailureMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<swim.JoinResponse> join(
        swim.JoinRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NOTIFY_FAILURE = 0;
  private static final int METHODID_JOIN = 1;

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
        case METHODID_NOTIFY_FAILURE:
          serviceImpl.notifyFailure((swim.NotifyFailureRequest) request,
              (io.grpc.stub.StreamObserver<swim.NotifyFailureAck>) responseObserver);
          break;
        case METHODID_JOIN:
          serviceImpl.join((swim.JoinRequest) request,
              (io.grpc.stub.StreamObserver<swim.JoinResponse>) responseObserver);
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
          getNotifyFailureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              swim.NotifyFailureRequest,
              swim.NotifyFailureAck>(
                service, METHODID_NOTIFY_FAILURE)))
        .addMethod(
          getJoinMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              swim.JoinRequest,
              swim.JoinResponse>(
                service, METHODID_JOIN)))
        .build();
  }

  private static abstract class DisseminationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DisseminationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return swim.Swim.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Dissemination");
    }
  }

  private static final class DisseminationFileDescriptorSupplier
      extends DisseminationBaseDescriptorSupplier {
    DisseminationFileDescriptorSupplier() {}
  }

  private static final class DisseminationMethodDescriptorSupplier
      extends DisseminationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DisseminationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DisseminationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DisseminationFileDescriptorSupplier())
              .addMethod(getNotifyFailureMethod())
              .addMethod(getJoinMethod())
              .build();
        }
      }
    }
    return result;
  }
}
