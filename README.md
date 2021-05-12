# Travel2wayStream
#Run this Application on your system :
1.Clone the GIT Project
2.Download Kafka
3.Run Command for starting the Zookeeper and Kafka Server
  #Some useful commnad for Windows to run kafka
    Start zookeeper->.\zookeeper-server-start.bat C:\Software\kafka_2.13-2.7.0\config\zookeeper.properties
    Start kafka->.\kafka-server-start.bat C:\Software\kafka_2.13-2.7.0\config\server.properties
    create topic ->.\kafka-topics.bat -zookeeper localhost:2181 -topic test -create -replication-factor 1 -partitions 1
    List Topic->.\kafka-topics.bat -zookeeper localhost:2181 -list
    Producer ->.\kafka-console-producer.bat --broker-list localhost:9092 --topic test
    Consumer->.\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test
    delete topic ->.\kafka-topics.bat -zookeeper localhost:2181 -topic test -delete
 4. Once kafka server is up using postman you can post a message to a producer.
 
    
