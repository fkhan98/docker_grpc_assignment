// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: swim.proto

package swim;

/**
 * Protobuf type {@code swim.IndirectPingRequest}
 */
public final class IndirectPingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:swim.IndirectPingRequest)
    IndirectPingRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IndirectPingRequest.newBuilder() to construct.
  private IndirectPingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IndirectPingRequest() {
    senderId_ = "";
    targetId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new IndirectPingRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return swim.Swim.internal_static_swim_IndirectPingRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return swim.Swim.internal_static_swim_IndirectPingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            swim.IndirectPingRequest.class, swim.IndirectPingRequest.Builder.class);
  }

  public static final int SENDER_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object senderId_ = "";
  /**
   * <code>string sender_id = 1;</code>
   * @return The senderId.
   */
  @java.lang.Override
  public java.lang.String getSenderId() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      senderId_ = s;
      return s;
    }
  }
  /**
   * <code>string sender_id = 1;</code>
   * @return The bytes for senderId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSenderIdBytes() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      senderId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TARGET_ID_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object targetId_ = "";
  /**
   * <code>string target_id = 2;</code>
   * @return The targetId.
   */
  @java.lang.Override
  public java.lang.String getTargetId() {
    java.lang.Object ref = targetId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      targetId_ = s;
      return s;
    }
  }
  /**
   * <code>string target_id = 2;</code>
   * @return The bytes for targetId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTargetIdBytes() {
    java.lang.Object ref = targetId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      targetId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(senderId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, targetId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(senderId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, targetId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof swim.IndirectPingRequest)) {
      return super.equals(obj);
    }
    swim.IndirectPingRequest other = (swim.IndirectPingRequest) obj;

    if (!getSenderId()
        .equals(other.getSenderId())) return false;
    if (!getTargetId()
        .equals(other.getTargetId())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SENDER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSenderId().hashCode();
    hash = (37 * hash) + TARGET_ID_FIELD_NUMBER;
    hash = (53 * hash) + getTargetId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static swim.IndirectPingRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static swim.IndirectPingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static swim.IndirectPingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static swim.IndirectPingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static swim.IndirectPingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static swim.IndirectPingRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(swim.IndirectPingRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code swim.IndirectPingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:swim.IndirectPingRequest)
      swim.IndirectPingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return swim.Swim.internal_static_swim_IndirectPingRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return swim.Swim.internal_static_swim_IndirectPingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              swim.IndirectPingRequest.class, swim.IndirectPingRequest.Builder.class);
    }

    // Construct using swim.IndirectPingRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      senderId_ = "";
      targetId_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return swim.Swim.internal_static_swim_IndirectPingRequest_descriptor;
    }

    @java.lang.Override
    public swim.IndirectPingRequest getDefaultInstanceForType() {
      return swim.IndirectPingRequest.getDefaultInstance();
    }

    @java.lang.Override
    public swim.IndirectPingRequest build() {
      swim.IndirectPingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public swim.IndirectPingRequest buildPartial() {
      swim.IndirectPingRequest result = new swim.IndirectPingRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(swim.IndirectPingRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.senderId_ = senderId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.targetId_ = targetId_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof swim.IndirectPingRequest) {
        return mergeFrom((swim.IndirectPingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(swim.IndirectPingRequest other) {
      if (other == swim.IndirectPingRequest.getDefaultInstance()) return this;
      if (!other.getSenderId().isEmpty()) {
        senderId_ = other.senderId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getTargetId().isEmpty()) {
        targetId_ = other.targetId_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              senderId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              targetId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object senderId_ = "";
    /**
     * <code>string sender_id = 1;</code>
     * @return The senderId.
     */
    public java.lang.String getSenderId() {
      java.lang.Object ref = senderId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        senderId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string sender_id = 1;</code>
     * @return The bytes for senderId.
     */
    public com.google.protobuf.ByteString
        getSenderIdBytes() {
      java.lang.Object ref = senderId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        senderId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sender_id = 1;</code>
     * @param value The senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      senderId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string sender_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSenderId() {
      senderId_ = getDefaultInstance().getSenderId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string sender_id = 1;</code>
     * @param value The bytes for senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      senderId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object targetId_ = "";
    /**
     * <code>string target_id = 2;</code>
     * @return The targetId.
     */
    public java.lang.String getTargetId() {
      java.lang.Object ref = targetId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        targetId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string target_id = 2;</code>
     * @return The bytes for targetId.
     */
    public com.google.protobuf.ByteString
        getTargetIdBytes() {
      java.lang.Object ref = targetId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        targetId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string target_id = 2;</code>
     * @param value The targetId to set.
     * @return This builder for chaining.
     */
    public Builder setTargetId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      targetId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string target_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTargetId() {
      targetId_ = getDefaultInstance().getTargetId();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string target_id = 2;</code>
     * @param value The bytes for targetId to set.
     * @return This builder for chaining.
     */
    public Builder setTargetIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      targetId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:swim.IndirectPingRequest)
  }

  // @@protoc_insertion_point(class_scope:swim.IndirectPingRequest)
  private static final swim.IndirectPingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new swim.IndirectPingRequest();
  }

  public static swim.IndirectPingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<IndirectPingRequest>
      PARSER = new com.google.protobuf.AbstractParser<IndirectPingRequest>() {
    @java.lang.Override
    public IndirectPingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<IndirectPingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IndirectPingRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public swim.IndirectPingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

