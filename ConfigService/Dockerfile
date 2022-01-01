FROM openjdk:11

MAINTAINER sa.maxwell@yahoo.com

VOLUME /tmp

# Set container environment variables
ENV EUREKASERVER_URI='http://eurekaservice:8761/eureka/'
ENV EUREKASERVER_PORT='8761'


RUN  apt update && apt upgrade && apt install netcat-openbsd && apt install curl
RUN mkdir -p /usr/local/app

ADD build/libs/ConfigService**.jar /usr/local/app/app.jar
ADD build/resources/main/** /usr/local/app
ADD scripts/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh