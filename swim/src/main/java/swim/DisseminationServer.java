package swim;

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

public class DisseminationServer extends DisseminationGrpc.DisseminationImplBase {

    private final String nodeId; // Current node ID (port)
    private final List<String> membershipList; // Membership list
    private final Set<String> alreadySeenFailures = ConcurrentHashMap.newKeySet(); // Track processed failures

    public DisseminationServer(String nodeId, List<String> initialMembership) {
        this.nodeId = nodeId;
        this.membershipList = new ArrayList<>(initialMembership);
    }

    @Override
    public void notifyFailure(NotifyFailureRequest request,
                              StreamObserver<NotifyFailureAck> responseObserver) {
        String failedNodeId = request.getFailedNodeId();

        // If we have already processed this node's failure, skip re-broadcast
        if (alreadySeenFailures.contains(failedNodeId)) {
            System.out.println("Component Dissemination of Node " + nodeId +
                    " ignores duplicate failure notification for Node " + failedNodeId);

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

        // Remove the failed node from membership
        membershipList.remove(failedNodeId);

        // Notify other nodes about failure
        // (Any node receiving it for the first time will also remove from membership,
        //  then do a single re-broadcast, etc.)
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
                        " runs RPC Join called by Component Dissemination of Node " +
                        request.getNewNodeId()
        );

        String newNodeId = request.getNewNodeId();
        // Add the new node if not already in membership
        if (!membershipList.contains(newNodeId)) {
            membershipList.add(newNodeId);
        }

        // Return updated membership list
        JoinResponse response = JoinResponse.newBuilder()
                .addAllMembershipList(membershipList)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * Notify all other members that a node has failed.
     */
    private void multicastFailure(String senderId, String failedNodeId) {
        for (String targetNode : membershipList) {
            // Skip the node that has failed (no need to call it)
            if (targetNode.equals(failedNodeId)) {
                continue;
            }

            System.out.println("Component Dissemination of Node " + nodeId +
                    " sends RPC NotifyFailure to Component Dissemination of Node " + targetNode);

            try {
                ManagedChannel channel = ManagedChannelBuilder
                        .forAddress("localhost", Integer.parseInt(targetNode))
                        .usePlaintext()
                        .build();

                DisseminationGrpc.DisseminationBlockingStub stub = DisseminationGrpc.newBlockingStub(channel);
                NotifyFailureRequest request = NotifyFailureRequest.newBuilder()
                        .setSenderId(senderId)
                        .setFailedNodeId(failedNodeId)
                        .build();

                // Perform the NotifyFailure call
                stub.notifyFailure(request);

                // Gracefully shut down the channel
                channel.shutdown();
            } catch (Exception e) {
                System.err.println("Failed to notify node " + targetNode + ": " + e.getMessage());
            }
        }
    }

    /**
     * Start the gRPC Dissemination server.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.err.println("Usage: java DisseminationServer <port> [member1 member2 ...]");
            System.exit(1);
        }

        // The first argument is the node ID (typically the port number, e.g. 60051)
        String nodeId = args[0];

        // Optional subsequent arguments are membership (other 600XX ports)
        List<String> membership = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            membership.add(args[i]);
        }

        DisseminationServer service = new DisseminationServer(nodeId, membership);

        // Build & start the gRPC Dissemination server
        Server server = NettyServerBuilder.forPort(Integer.parseInt(nodeId))
                .addService(service)
                .build()
                .start();

        System.out.println("Java Dissemination Server started at port " + nodeId);

        // Add a shutdown hook for graceful termination
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Dissemination Server on Node " + nodeId);
            server.shutdown();
            try {
                server.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        // Wait for the server to terminate
        server.awaitTermination();
    }
}
