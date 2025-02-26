// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: swim.proto

package swim;

/**
 * Protobuf type {@code swim.IndirectPingAck}
 */
public final class IndirectPingAck extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:swim.IndirectPingAck)
    IndirectPingAckOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IndirectPingAck.newBuilder() to construct.
  private IndirectPingAck(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IndirectPingAck() {
    targetId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new IndirectPingAck();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return swim.Swim.internal_static_swim_IndirectPingAck_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return swim.Swim.internal_static_swim_IndirectPingAck_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            swim.IndirectPingAck.class, swim.IndirectPingAck.Builder.class);
  }

  public static final int TARGET_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object targetId_ = "";
  /**
   * <code>string target_id = 1;</code>
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
   * <code>string target_id = 1;</code>
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

  public static final int ACK_FIELD_NUMBER = 2;
  private boolean ack_ = false;
  /**
   * <code>bool ack = 2;</code>
   * @return The ack.
   */
  @java.lang.Override
  public boolean getAck() {
    return ack_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, targetId_);
    }
    if (ack_ != false) {
      output.writeBool(2, ack_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(targetId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, targetId_);
    }
    if (ack_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, ack_);
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
    if (!(obj instanceof swim.IndirectPingAck)) {
      return super.equals(obj);
    }
    swim.IndirectPingAck other = (swim.IndirectPingAck) obj;

    if (!getTargetId()
        .equals(other.getTargetId())) return false;
    if (getAck()
        != other.getAck()) return false;
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
    hash = (37 * hash) + TARGET_ID_FIELD_NUMBER;
    hash = (53 * hash) + getTargetId().hashCode();
    hash = (37 * hash) + ACK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAck());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static swim.IndirectPingAck parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingAck parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingAck parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingAck parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingAck parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static swim.IndirectPingAck parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static swim.IndirectPingAck parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static swim.IndirectPingAck parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static swim.IndirectPingAck parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static swim.IndirectPingAck parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static swim.IndirectPingAck parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static swim.IndirectPingAck parseFrom(
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
  public static Builder newBuilder(swim.IndirectPingAck prototype) {
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
   * Protobuf type {@code swim.IndirectPingAck}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:swim.IndirectPingAck)
      swim.IndirectPingAckOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return swim.Swim.internal_static_swim_IndirectPingAck_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return swim.Swim.internal_static_swim_IndirectPingAck_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              swim.IndirectPingAck.class, swim.IndirectPingAck.Builder.class);
    }

    // Construct using swim.IndirectPingAck.newBuilder()
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
      targetId_ = "";
      ack_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return swim.Swim.internal_static_swim_IndirectPingAck_descriptor;
    }

    @java.lang.Override
    public swim.IndirectPingAck getDefaultInstanceForType() {
      return swim.IndirectPingAck.getDefaultInstance();
    }

    @java.lang.Override
    public swim.IndirectPingAck build() {
      swim.IndirectPingAck result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public swim.IndirectPingAck buildPartial() {
      swim.IndirectPingAck result = new swim.IndirectPingAck(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(swim.IndirectPingAck result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.targetId_ = targetId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.ack_ = ack_;
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
      if (other instanceof swim.IndirectPingAck) {
        return mergeFrom((swim.IndirectPingAck)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(swim.IndirectPingAck other) {
      if (other == swim.IndirectPingAck.getDefaultInstance()) return this;
      if (!other.getTargetId().isEmpty()) {
        targetId_ = other.targetId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getAck() != false) {
        setAck(other.getAck());
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
              targetId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              ack_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
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

    private java.lang.Object targetId_ = "";
    /**
     * <code>string target_id = 1;</code>
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
     * <code>string target_id = 1;</code>
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
     * <code>string target_id = 1;</code>
     * @param value The targetId to set.
     * @return This builder for chaining.
     */
    public Builder setTargetId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      targetId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string target_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTargetId() {
      targetId_ = getDefaultInstance().getTargetId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string target_id = 1;</code>
     * @param value The bytes for targetId to set.
     * @return This builder for chaining.
     */
    public Builder setTargetIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      targetId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private boolean ack_ ;
    /**
     * <code>bool ack = 2;</code>
     * @return The ack.
     */
    @java.lang.Override
    public boolean getAck() {
      return ack_;
    }
    /**
     * <code>bool ack = 2;</code>
     * @param value The ack to set.
     * @return This builder for chaining.
     */
    public Builder setAck(boolean value) {

      ack_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool ack = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAck() {
      bitField0_ = (bitField0_ & ~0x00000002);
      ack_ = false;
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


    // @@protoc_insertion_point(builder_scope:swim.IndirectPingAck)
  }

  // @@protoc_insertion_point(class_scope:swim.IndirectPingAck)
  private static final swim.IndirectPingAck DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new swim.IndirectPingAck();
  }

  public static swim.IndirectPingAck getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<IndirectPingAck>
      PARSER = new com.google.protobuf.AbstractParser<IndirectPingAck>() {
    @java.lang.Override
    public IndirectPingAck parsePartialFrom(
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

  public static com.google.protobuf.Parser<IndirectPingAck> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IndirectPingAck> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public swim.IndirectPingAck getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

