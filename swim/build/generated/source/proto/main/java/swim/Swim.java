// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: swim.proto

package swim;

public final class Swim {
  private Swim() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_PingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_PingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_PingAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_PingAck_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_IndirectPingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_IndirectPingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_IndirectPingAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_IndirectPingAck_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_FailedNodeRemovalRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_FailedNodeRemovalRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_FailedNodeRemovedAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_FailedNodeRemovedAck_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_NewNodeJoinRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_NewNodeJoinRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_NewNodeJoinAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_NewNodeJoinAck_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_NotifyFailureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_NotifyFailureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_NotifyFailureAck_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_NotifyFailureAck_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_JoinRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_JoinRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_swim_JoinResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_swim_JoinResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nswim.proto\022\004swim\" \n\013PingRequest\022\021\n\tsen" +
      "der_id\030\001 \001(\t\"\026\n\007PingAck\022\013\n\003ack\030\001 \001(\010\";\n\023" +
      "IndirectPingRequest\022\021\n\tsender_id\030\001 \001(\t\022\021" +
      "\n\ttarget_id\030\002 \001(\t\"1\n\017IndirectPingAck\022\021\n\t" +
      "target_id\030\001 \001(\t\022\013\n\003ack\030\002 \001(\010\"E\n\030FailedNo" +
      "deRemovalRequest\022\021\n\tsender_id\030\001 \001(\t\022\026\n\016f" +
      "ailed_node_id\030\002 \001(\t\"#\n\024FailedNodeRemoved" +
      "Ack\022\013\n\003ack\030\001 \001(\010\"<\n\022NewNodeJoinRequest\022\021" +
      "\n\tsender_id\030\001 \001(\t\022\023\n\013new_node_id\030\002 \001(\t\"\035" +
      "\n\016NewNodeJoinAck\022\013\n\003ack\030\001 \001(\010\"A\n\024NotifyF" +
      "ailureRequest\022\021\n\tsender_id\030\001 \001(\t\022\026\n\016fail" +
      "ed_node_id\030\002 \001(\t\"\037\n\020NotifyFailureAck\022\013\n\003" +
      "ack\030\001 \001(\010\":\n\013JoinRequest\022\023\n\013new_node_id\030" +
      "\001 \001(\t\022\026\n\016bootstrap_node\030\002 \001(\t\"\'\n\014JoinRes" +
      "ponse\022\027\n\017membership_list\030\001 \003(\t2\214\002\n\017Failu" +
      "reDetector\022(\n\004Ping\022\021.swim.PingRequest\032\r." +
      "swim.PingAck\022@\n\014IndirectPing\022\031.swim.Indi" +
      "rectPingRequest\032\025.swim.IndirectPingAck\022N" +
      "\n\020RemoveFailedNode\022\036.swim.FailedNodeRemo" +
      "valRequest\032\032.swim.FailedNodeRemovedAck\022=" +
      "\n\013JoinNewNode\022\030.swim.NewNodeJoinRequest\032" +
      "\024.swim.NewNodeJoinAck2\203\001\n\rDissemination\022" +
      "C\n\rNotifyFailure\022\032.swim.NotifyFailureReq" +
      "uest\032\026.swim.NotifyFailureAck\022-\n\004Join\022\021.s" +
      "wim.JoinRequest\032\022.swim.JoinResponseB\010\n\004s" +
      "wimP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_swim_PingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_swim_PingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_PingRequest_descriptor,
        new java.lang.String[] { "SenderId", });
    internal_static_swim_PingAck_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_swim_PingAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_PingAck_descriptor,
        new java.lang.String[] { "Ack", });
    internal_static_swim_IndirectPingRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_swim_IndirectPingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_IndirectPingRequest_descriptor,
        new java.lang.String[] { "SenderId", "TargetId", });
    internal_static_swim_IndirectPingAck_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_swim_IndirectPingAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_IndirectPingAck_descriptor,
        new java.lang.String[] { "TargetId", "Ack", });
    internal_static_swim_FailedNodeRemovalRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_swim_FailedNodeRemovalRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_FailedNodeRemovalRequest_descriptor,
        new java.lang.String[] { "SenderId", "FailedNodeId", });
    internal_static_swim_FailedNodeRemovedAck_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_swim_FailedNodeRemovedAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_FailedNodeRemovedAck_descriptor,
        new java.lang.String[] { "Ack", });
    internal_static_swim_NewNodeJoinRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_swim_NewNodeJoinRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_NewNodeJoinRequest_descriptor,
        new java.lang.String[] { "SenderId", "NewNodeId", });
    internal_static_swim_NewNodeJoinAck_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_swim_NewNodeJoinAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_NewNodeJoinAck_descriptor,
        new java.lang.String[] { "Ack", });
    internal_static_swim_NotifyFailureRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_swim_NotifyFailureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_NotifyFailureRequest_descriptor,
        new java.lang.String[] { "SenderId", "FailedNodeId", });
    internal_static_swim_NotifyFailureAck_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_swim_NotifyFailureAck_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_NotifyFailureAck_descriptor,
        new java.lang.String[] { "Ack", });
    internal_static_swim_JoinRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_swim_JoinRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_JoinRequest_descriptor,
        new java.lang.String[] { "NewNodeId", "BootstrapNode", });
    internal_static_swim_JoinResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_swim_JoinResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_swim_JoinResponse_descriptor,
        new java.lang.String[] { "MembershipList", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
