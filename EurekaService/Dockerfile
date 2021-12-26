FROM openjdk:11

MAINTAINER sa.maxwell@yahoo.com

RUN  apt update && apt upgrade && apt install netcat-openbsd && apt install curl
RUN mkdir -p /usr/local/app

ADD build/libs/EurekaService**.jar /usr/local/app/app.jar
ADD scripts/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh