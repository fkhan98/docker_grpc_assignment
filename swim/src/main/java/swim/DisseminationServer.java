package swim;

import swim.FailedNodeRemovalRequest;
import swim.FailedNodeRemovedAck;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple utility class to store host+port parsing results.
 */
// CHANGED: New helper class
class HostPort {
    String host;
    int port;

    HostPort(String host, int port) {
        this.host = host;
        this.port = port;
    }
}

public class DisseminationServer extends DisseminationGrpc.DisseminationImplBase {

    private final String nodeId; // e.g. "java-d-1:60051"
    private final List<String> membershipList; 
    private final Set<String> alreadySeenFailures = ConcurrentHashMap.newKeySet(); 

    public DisseminationServer(String nodeId, List<String> initialMembership) {
        this.nodeId = nodeId;
        this.membershipList = new ArrayList<>(initialMembership);
    }

    // CHANGED: Utility to parse strings like "java-d-2:60052" => HostPort("java-d-2", 60052)
    public static HostPort parseHostPort(String hostPortStr) {
        String[] parts = hostPortStr.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Membership entry must be 'host:port' but got: " + hostPortStr);
        }
        return new HostPort(parts[0], Integer.parseInt(parts[1]));
    }

    @Override
    public void notifyFailure(NotifyFailureRequest request,
                              StreamObserver<NotifyFailureAck> responseObserver) {
        String failedNodeId = request.getFailedNodeId();

        // If we have already processed this node's failure, skip re-broadcast
        if (alreadySeenFailures.contains(failedNodeId)) {
            // System.out.println("Component Dissemination of Node " + nodeId +
            //         " ignores duplicate failure notification for Node " + failedNodeId);

            NotifyFailureAck response = NotifyFailureAck.newBuilder()
                    .setAck(true)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        // Mark the failed node as processed so we don't rebroadcast it again
        alreadySeenFailures.add(failedNodeId);

        System.out.println(
                "Component Dissemination of Node " + nodeId +
                " runs RPC NotifyFailure called by Component Dissemination of Node " +
                request.getSenderId()
        );
        System.out.flush();

        // Remove the failed node from membership
        membershipList.remove(failedNodeId);

        // Notify local FD that the node failed
        notifyFailureDetectors(failedNodeId);

        // Notify other nodes about failure
        multicastFailure(request.getSenderId(), failedNodeId);

        // Send Ack response back to the caller
        NotifyFailureAck response = NotifyFailureAck.newBuilder()
                .setAck(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void join(JoinRequest request,
                     StreamObserver<JoinResponse> responseObserver) {
        System.out.println(
                "Component Dissemination of Node " + nodeId +
                " runs RPC Join for new Node " +
                request.getNewNodeId()
        );
        System.out.flush();
        String newNodeId = request.getNewNodeId();
        // Add the new node if not already in membership
        if (!membershipList.contains(newNodeId)) {
            membershipList.add(newNodeId);
        }

        // Tell FD that a new node joined
        notifyFdJoin(newNodeId);

        // If this node is the bootstrap node, multicast the join
        String bootstrapNode = request.getBootstrapNode(); 
        if (nodeId.equals(bootstrapNode)) {
            multicastJoin(newNodeId);
        }

        // Return updated membership list
        JoinResponse response = JoinResponse.newBuilder()
                .addAllMembershipList(membershipList)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void notifyFdJoin(String newNodeId) {
        try {
            // CHANGED: parse local node ID => "java-d-1:60051" => HostPort("java-d-1",60051)
            HostPort selfHp = parseHostPort(nodeId);

            // Convert "java-d-1" => "python-fd-1", and port => port - 10000
            String suffix = selfHp.host.substring("java-d-".length()); // e.g. "1"
            String fdHost = "python-fd-" + suffix;                     // e.g. "python-fd-1"
            int fdPort = selfHp.port - 10000;                          // e.g. 50051

            // newNodeId might be "java-d-2:60052" => parse that too if you want to pass that logic
            System.out.println("Component Dissemination of Node " + nodeId +
                    " sending New Node Join Notification RPC to Failure Detector at " + fdHost + ":" + fdPort);
            System.out.flush();
            // CHANGED: remove localhost
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(fdHost, fdPort)
                    .usePlaintext()
                    .build();

            FailureDetectorGrpc.FailureDetectorBlockingStub stub = FailureDetectorGrpc.newBlockingStub(channel);

            NewNodeJoinRequest request = NewNodeJoinRequest.newBuilder()
                    .setSenderId(nodeId)    // or just the suffix, your choice
                    .setNewNodeId(newNodeId)
                    .build();

            NewNodeJoinAck response = stub.joinNewNode(request);

            if (response.getAck()) {
                System.out.println("Python FD at " + fdHost + ":" + fdPort + 
                                   " added new node " + newNodeId);
                System.out.flush();
            }

            // Close channel
            channel.shutdown();

        } catch (Exception e) {
            System.err.println("Failed to notify Failure Detector: " + e.getMessage());
        }
    }

    private void multicastJoin(String newNodeId) {
        for (String targetNode : membershipList) {
            if (targetNode.equals(newNodeId)) {
                continue;
            }

            System.out.println("Component Dissemination of Node " + nodeId +
                    " sends RPC Join to Component Dissemination of Node " + targetNode);
            System.out.flush();
            try {
                // CHANGED: parse "host:port"
                HostPort hp = parseHostPort(targetNode);

                ManagedChannel channel = ManagedChannelBuilder
                        .forAddress(hp.host, hp.port) // CHANGED: remove localhost
                        .usePlaintext()
                        .build();

                DisseminationGrpc.DisseminationBlockingStub stub = DisseminationGrpc.newBlockingStub(channel);
                JoinRequest request = JoinRequest.newBuilder()
                        .setNewNodeId(newNodeId)
                        .build();

                // Perform the Join call
                stub.join(request);

                // Gracefully shut down
                channel.shutdown();
            } catch (Exception e) {
                System.err.println("Failed to notify node " + targetNode + ": " + e.getMessage());
                System.out.flush();
            }
        }
    }

    private void multicastFailure(String senderId, String failedNodeId) {
        for (String targetNode : membershipList) {
            if (targetNode.equals(failedNodeId)) {
                continue;
            }

            System.out.println("Component Dissemination of Node " + nodeId +
                    " sends RPC NotifyFailure to Component Dissemination of Node " + targetNode);
            System.out.flush();
            try {
                // CHANGED: parse "host:port"
                HostPort hp = parseHostPort(targetNode);

                ManagedChannel channel = ManagedChannelBuilder
                        .forAddress(hp.host, hp.port) // CHANGED
                        .usePlaintext()
                        .build();

                DisseminationGrpc.DisseminationBlockingStub stub = DisseminationGrpc.newBlockingStub(channel);
                NotifyFailureRequest request = NotifyFailureRequest.newBuilder()
                        .setSenderId(nodeId)
                        .setFailedNodeId(failedNodeId)
                        .build();

                stub.notifyFailure(request);
                channel.shutdown();
            } catch (Exception e) {
                System.err.println("Failed to notify node " + targetNode + ": " + e.getMessage());
                System.out.flush();
            }
        }
    }

    private void notifyFailureDetectors(String failedNodeId) {
        try {
            // CHANGED: parse local node => "java-d-X:6005X"
            HostPort selfHp = parseHostPort(nodeId);
            String suffix = selfHp.host.substring("java-d-".length());
            String fdHost = "python-fd-" + suffix;
            int fdPort = selfHp.port - 10000;

            HostPort failedHp = parseHostPort(failedNodeId);
            String failedsuffix = failedHp.host.substring("java-d-".length());
            String failedfdHost = "python-fd-" + failedsuffix;
            int failedfdPort = failedHp.port - 10000;
            String fdFailedNode = failedfdHost + ":" + failedfdPort;

            // Possibly parse "failedNodeId" if you want to pass the exact string
            System.out.println("Component Dissemination of Node " + nodeId +
                    " sending NotifyFailure RPC to Failure Detector at " + fdHost + ":" + fdPort);
            System.out.flush();
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(fdHost, fdPort)  // CHANGED: remove localhost
                    .usePlaintext()
                    .build();

            FailureDetectorGrpc.FailureDetectorBlockingStub stub = FailureDetectorGrpc.newBlockingStub(channel);

            FailedNodeRemovalRequest request = FailedNodeRemovalRequest.newBuilder()
                    .setSenderId(nodeId)          // or suffix
                    // .setFailedNodeId(failedNodeId) 
                    .setFailedNodeId(fdFailedNode) 
                    .build();

            FailedNodeRemovedAck response = stub.removeFailedNode(request);

            if (response.getAck()) {
                System.out.println("Python FD at " + fdHost + ":" + fdPort
                        + " removed Node " + failedNodeId);
                System.out.flush();
            }

            channel.shutdown();
        } catch (Exception e) {
            System.err.println("Failed to notify Failure Detector: " + e.getMessage());
            System.out.flush();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.err.println("Usage: java DisseminationServer <host:port> [member1 member2 ...]");
            System.exit(1);
        }

        String[] initialMembers = {"java-d-1:60051", "java-d-2:60052", "java-d-3:60053", "java-d-4:60054", "java-d-5:60055"};
        // CHANGED: We now expect something like "java-d-1:60051" for nodeId
        String nodeId = args[0];

        List<String> membership = new ArrayList<>();
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                membership.add(args[i]); // e.g. "java-d-2:60052"
            }
        }

        if (membership.isEmpty()) {
            try{
                HostPort bootstrap = parseHostPort(initialMembers[1]);
                String bootstrapNode = initialMembers[1];
                ManagedChannel channel = ManagedChannelBuilder
                        .forAddress(bootstrap.host, bootstrap.port)
                        .usePlaintext()
                        .build();

                DisseminationGrpc.DisseminationBlockingStub stub = DisseminationGrpc.newBlockingStub(channel);
                JoinRequest request = JoinRequest.newBuilder()
                    .setNewNodeId(nodeId)
                    .setBootstrapNode(bootstrapNode)
                    .build();

                JoinResponse response = stub.join(request);

                membership.add(bootstrapNode);
                membership.addAll(response.getMembershipListList());
                membership.remove(nodeId);
                System.err.println(membership);
                // Close the channel later in your actual use case when necessary
                channel.shutdown();
            } catch (Exception e) {
                System.err.println("Error joining the cluster: " + e.getMessage());
                System.exit(1);
            }
        }

        DisseminationServer service = new DisseminationServer(nodeId, membership);

        // CHANGED: parse the host:port from nodeId to run the server
        String[] hostPortParts = nodeId.split(":");
        String host = hostPortParts[0];
        int port = Integer.parseInt(hostPortParts[1]);

        // Start the gRPC server
        Server server = NettyServerBuilder
                .forPort(port)
                .addService(service)
                .build()
                .start();

        System.out.println("Java Dissemination Server started at " + nodeId);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Dissemination Server on Node " + nodeId);
            server.shutdown();
            try {
                server.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        server.awaitTermination();
    }
}
