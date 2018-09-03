# Java Messaging
Demo using Spring and JMS system: ActiveMQ, RabbitMQ

### Docker
Start Docker containers:  
`docker-compose -f jms-stack.yml up`  
(add `-d` if you want to start container in daemon)

### Admin pages:
(I'm using [Docker Toolbox on Windows](https://www.docker.com/docker-toolbox), and my Docker is running on 192.168.99.100)

ActiveMQ: 
http://192.168.99.100:8161

RabbitMQ:
http://192.168.99.100:15672

### Run
Import file _Spring&JMS.postman_collection.json_ to [Postman](https://www.getpostman.com/) and execute
