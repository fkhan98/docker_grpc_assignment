# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: swim.proto
# Protobuf Python Version: 5.29.0
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import runtime_version as _runtime_version
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
_runtime_version.ValidateProtobufRuntimeVersion(
    _runtime_version.Domain.PUBLIC,
    5,
    29,
    0,
    '',
    'swim.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\nswim.proto\x12\x04swim\" \n\x0bPingRequest\x12\x11\n\tsender_id\x18\x01 \x01(\t\"\x16\n\x07PingAck\x12\x0b\n\x03\x61\x63k\x18\x01 \x01(\x08\";\n\x13IndirectPingRequest\x12\x11\n\tsender_id\x18\x01 \x01(\t\x12\x11\n\ttarget_id\x18\x02 \x01(\t\"1\n\x0fIndirectPingAck\x12\x11\n\ttarget_id\x18\x01 \x01(\t\x12\x0b\n\x03\x61\x63k\x18\x02 \x01(\x08\"E\n\x18\x46\x61iledNodeRemovalRequest\x12\x11\n\tsender_id\x18\x01 \x01(\t\x12\x16\n\x0e\x66\x61iled_node_id\x18\x02 \x01(\t\"#\n\x14\x46\x61iledNodeRemovedAck\x12\x0b\n\x03\x61\x63k\x18\x01 \x01(\x08\"<\n\x12NewNodeJoinRequest\x12\x11\n\tsender_id\x18\x01 \x01(\t\x12\x13\n\x0bnew_node_id\x18\x02 \x01(\t\"\x1d\n\x0eNewNodeJoinAck\x12\x0b\n\x03\x61\x63k\x18\x01 \x01(\x08\"A\n\x14NotifyFailureRequest\x12\x11\n\tsender_id\x18\x01 \x01(\t\x12\x16\n\x0e\x66\x61iled_node_id\x18\x02 \x01(\t\"\x1f\n\x10NotifyFailureAck\x12\x0b\n\x03\x61\x63k\x18\x01 \x01(\x08\"\"\n\x0bJoinRequest\x12\x13\n\x0bnew_node_id\x18\x01 \x01(\t\"\'\n\x0cJoinResponse\x12\x17\n\x0fmembership_list\x18\x01 \x03(\t2\x8c\x02\n\x0f\x46\x61ilureDetector\x12(\n\x04Ping\x12\x11.swim.PingRequest\x1a\r.swim.PingAck\x12@\n\x0cIndirectPing\x12\x19.swim.IndirectPingRequest\x1a\x15.swim.IndirectPingAck\x12N\n\x10RemoveFailedNode\x12\x1e.swim.FailedNodeRemovalRequest\x1a\x1a.swim.FailedNodeRemovedAck\x12=\n\x0bJoinNewNode\x12\x18.swim.NewNodeJoinRequest\x1a\x14.swim.NewNodeJoinAck2\x83\x01\n\rDissemination\x12\x43\n\rNotifyFailure\x12\x1a.swim.NotifyFailureRequest\x1a\x16.swim.NotifyFailureAck\x12-\n\x04Join\x12\x11.swim.JoinRequest\x1a\x12.swim.JoinResponseB\x08\n\x04swimP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'swim_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  _globals['DESCRIPTOR']._loaded_options = None
  _globals['DESCRIPTOR']._serialized_options = b'\n\004swimP\001'
  _globals['_PINGREQUEST']._serialized_start=20
  _globals['_PINGREQUEST']._serialized_end=52
  _globals['_PINGACK']._serialized_start=54
  _globals['_PINGACK']._serialized_end=76
  _globals['_INDIRECTPINGREQUEST']._serialized_start=78
  _globals['_INDIRECTPINGREQUEST']._serialized_end=137
  _globals['_INDIRECTPINGACK']._serialized_start=139
  _globals['_INDIRECTPINGACK']._serialized_end=188
  _globals['_FAILEDNODEREMOVALREQUEST']._serialized_start=190
  _globals['_FAILEDNODEREMOVALREQUEST']._serialized_end=259
  _globals['_FAILEDNODEREMOVEDACK']._serialized_start=261
  _globals['_FAILEDNODEREMOVEDACK']._serialized_end=296
  _globals['_NEWNODEJOINREQUEST']._serialized_start=298
  _globals['_NEWNODEJOINREQUEST']._serialized_end=358
  _globals['_NEWNODEJOINACK']._serialized_start=360
  _globals['_NEWNODEJOINACK']._serialized_end=389
  _globals['_NOTIFYFAILUREREQUEST']._serialized_start=391
  _globals['_NOTIFYFAILUREREQUEST']._serialized_end=456
  _globals['_NOTIFYFAILUREACK']._serialized_start=458
  _globals['_NOTIFYFAILUREACK']._serialized_end=489
  _globals['_JOINREQUEST']._serialized_start=491
  _globals['_JOINREQUEST']._serialized_end=525
  _globals['_JOINRESPONSE']._serialized_start=527
  _globals['_JOINRESPONSE']._serialized_end=566
  _globals['_FAILUREDETECTOR']._serialized_start=569
  _globals['_FAILUREDETECTOR']._serialized_end=837
  _globals['_DISSEMINATION']._serialized_start=840
  _globals['_DISSEMINATION']._serialized_end=971
# @@protoc_insertion_point(module_scope)
