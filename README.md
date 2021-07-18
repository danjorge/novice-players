# Project novice-players

---
### Getting Started
- To use kafka, you have to download the version of the project [Here](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.8.0/kafka_2.13-2.8.0.tgz)
- The version of kafka used in this project is **_2.13-2.8.0_**

Before start Apache Kafka, we need to do the following:
```
# Extract the tgz file if you use macos with this command
tar -xzf kafka_2.13-2.8.0.tgz 
# navigate to inside the extracted directory
cd kafka_2.13-2.8.0
```

### Command to start kafka
```
# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Open another terminal session and run:
```
# Start the Kafka broker service
bin/kafka-server-start.sh config/server.properties
```

If you want to start kafta on docker locally, just run the following command inside the root directory of the project:
```
docker-compose up
```

### Command to create topic
```
bin/kafka-topics.sh --create --topic novice-players --bootstrap-server localhost:9092
```
To describe the topic, use:
```
bin/kafka-topics.sh --describe --topic novice-players --bootstrap-server localhost:9092
```

### Command to read an event into the topic
```
bin/kafka-console-consumer.sh --topic novice-players --from-beginning --bootstrap-server localhost:9092
```

### Command to run spring boot

Navigate to the root of the project (e.g. cd path/to/the/project), 
open a terminal and run

- Maven
```
./mvnw spring-boot:run
```

- Gradle
```
./gradlew bootRun
```

There are some unit and integration tests and can be executed with the following command
```
#Unit
./gradlew :test --tests "com.truelogic.noviceplayers.service.PlayerServiceTest"
#Integration
./gradlew :test --tests "com.truelogic.noviceplayers.kafka.EmbeddedKafkaIntegrationTest"
```