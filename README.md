When multiple instances of a microservice is deployed and the requirement comes stating only one of the instances should perform a particular task with zero downtime, i.e. if the performer instance gets down, one of the other instances should take up the task, we need distributed locking to address this problem. Here is a simple implementation of the same using Zookeeper and spring boot applications.

Follow the instructions in the README to run the application. For more information visit : https://medium.com/@dibyajyotidhar/implement-distributed-locking-in-spring-boot-microservices-using-zookeeper-ff7c02b90478

1. Make sure Docker is running in your PC.

2. Create Docker Network for Zookeeper instances internal communication.
```
docker network create zookeeper-network
```

3. Run the distributed Zookeeper server
```
docker-compose up -d
```

4. Run the springboot application `serv1/dldemo` amd `serv2/dldemo` in your favourite IDE, and play around with them.
