# Docker gRPC Assignment



To download the assignment, clone the repository:

```console
git clone https://github.com/fkhan98/docker_grpc_assignment.git
```



### Question 3:
Navigate to the weather_update directory:

```console
cd weather_update
```


Install the necessary modules:

```console
pip install -r requirements.txt
```


The `service.proto` file is defined under the `proto/` folder.

#### Building gRPC Code:

#### Java:
To build the Java code from the `.proto` file, run:


```
./gradlew clean build
```



#### Python:
To build the Python code from the `.proto` file, run:

```console
python -m grpc_tools.protoc
--proto_path=.
--python_out=.
--grpc_python_out=. proto/service.proto
```


#### Server and Client Locations:

- The `javaClient.java` and `javaServer.java` files are located under:
`src/main/java/com/example/grpc`



- The `python_server.py` and `python_client.py` files are located in:
`./`


#### Dockerization:

All server-client applications have been containerized using Docker. The corresponding Dockerfiles are:

- `Dockerfile.java_client`
- `Dockerfile.java_server`
- `Dockerfile.python_client`
- `Dockerfile.python_server`

To run all containers, a `docker-compose.yml` file is provided.

#### Running the Containers:

```console
docker-compose up --build
```

#### Running the Code Without Docker-Compose:
Python Server:
```console
python python_server.py
```
Python Client:
```console
python python_client.py
```
Java Server:
```console
./gradlew run
```
Java Client:
```console
./gradlew run -PmainClass=com.example.grpc.JavaClient
```

### Question 4: Failure Detection Service
Navigate to the swim directory:

```console
cd swim
```

The failure detection service methods are defined in the `swim.proto` file.

#### Building gRPC Code:
To generate the Python code from the `.proto` file, run:

```console
python -m grpc_tools.protoc \
  --proto_path=. \
  --python_out=. \
  --grpc_python_out=. \
  swim.proto
```

#### Running the Failure Detection Nodes:
The service methods for the failure detection component for each node are implemented in: `python_fd.py`
<br>
To run the Failure Detection Component of each node, execute the following command, specifying its own port number and a membership list as arguments:

#### Example for running Node 1:
```console
python fd_node.py --port 50051 --membership 50052 50053 50054 50055
```
#### Example for running Node 2:
```console
python fd_node.py --port 50052 --membership 50051 50053 50054 50055
```

In this setup, each node acts as both a client and a server, handling Ping and Indirect Ping Requests to and from other nodes.

#### Dockerization:
The python_fd node has been containerized using `Dockerfile.fd.`

It is recommended to run the containerized version of the nodes instead of executing them locally, as the ports are properly managed within the containers.

## Question 5: Dissemination Service

The dissemination service runs in the same directory as Failure Detection in the `swim` folder.
The dissemination service methods are also defined in the `swim.proto` file.
<br>
From previous question, the proto files for python code has been generated.


#### Building gRPC Code:
To generate the Java code from the `.proto` file, run:
```console
./gradlew clean build
```

#### Running the Dissemination Component of the Nodes:
The service methods for the Dissemination Component for each node are implemented in: `DisseminationServer.java` under `src/main/java/swim` folder.
<br>
To run the Dissemination Component of each node, execute the following command, specifying its own port number and a membership list as arguments: (no need to redirect to any other directory)

#### Example for running Node 1:
```console
./gradlew run --args="60051 60052 60053 60054 60055"
```
#### Example for running Node 2:
```console
./gradlew run --args="60052 60051 60053 60054 60055"
```

In this setup, each node functions as both a client and a server, receiving and multicasting Failure and Join Notifications from and to other nodes. Here, the Failure Detection Component interacts with the Dissemination Component. When a node detects a failure, its Failure Detection Component notifies its own Dissemination Component, which then multicasts the failure notification to all other nodes in its membership list.
<br>
To test a new join request in the cluster, run after 1/2 minutes:

```console
./gradlew run --args="60056"
```
Here, the node 60052 acts as a bootsrap node multicasting the join request of 60056 to all other nodes in teh membership list and returning an updated membership list.

#### Dockerization:
The DisseminationServer.java nodes has been containerized using `Dockerfile.dc`

Both the Failure Detection Component and Dissemination component for 5 different nodes has been dockerized and
To run all containers, a `docker-compose.yml` file is provided. 

### Running the Containers:

```console
docker-compose up --build
```

It is recommended to run the containerized version of the nodes instead of executing them locally, as the ports are properly managed within the containers.