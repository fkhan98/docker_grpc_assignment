// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: swim.proto

package swim;

public interface IndirectPingAckOrBuilder extends
    // @@protoc_insertion_point(interface_extends:swim.IndirectPingAck)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string target_id = 1;</code>
   * @return The targetId.
   */
  java.lang.String getTargetId();
  /**
   * <code>string target_id = 1;</code>
   * @return The bytes for targetId.
   */
  com.google.protobuf.ByteString
      getTargetIdBytes();

  /**
   * <code>bool ack = 2;</code>
   * @return The ack.
   */
  boolean getAck();
}
