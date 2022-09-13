# Apache-Pulsar-Spring-Boot
Apache-Pulsar-Spring-Boot-Docker

Install pulsar and Run Container:
    docker run -it -p 6650:6650 -p 8080:8080 --mount source=pulsardata,target=/pulsar/data --mount source=pulsarconf,target=/pulsar/conf apachepulsar/pulsar:2.8.0 bin/pulsar standalone

Run container when pulsar already installed:
    docker run -it -p 6650:6650 -p 8080:8080 apachepulsar/pulsar:2.8.0 bin/pulsar standalone


Local docker:

Consumer topic: 
$ docker exec -it <container id> /bin/bash
$ cd bin/
$ ./pulsar-client consume  prices -s  "Shares"   


Create topic: 
./pulsar-client produce bidsheetprice --messages "300"

./pulsar-client produce pricesproducer --messages "Hi Prod shares"


  UseFul Links: https://www.lionbloggertech.com/setup-producer-consumer-for-apache-pulsar-running-on-docker/
  https://github.com/majusko/pulsar-java-spring-boot-starter
