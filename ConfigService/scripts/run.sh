#!/bin/sh

echo "**************************************************************"
echo "Configuration server - Waiting for the eureka server to start"
echo "**************************************************************"

while ! `nc -z eurekaserver $EUREKASERVER_PORT`; do sleep 3; done
echo ">>>>>>>>>>>> Eureka Server has started"

echo "*******************************"
echo "Starting Configuration Service"
echo "*******************************"
java -Djava.security.egd=file:/dev/./urandom \
	 -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI \
	 -jar /usr/local/app/app.jar