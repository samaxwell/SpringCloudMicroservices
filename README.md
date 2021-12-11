# Microservices


### Description

A basic microservice setup to practice the following:
- new(ish) Spring Cloud Api Gateway
- distributed tracing w/ Sleuth, Zipkin, Elastic Stack
- Resiliency w/ Hystrix


### URLs
Config Server: localhost:8888 <br>
Eureka: localhost:8761 <br>
Blog Service: localhost:9090 <br>
API Gateway: localhost:8080 <br>


### Service Discovery

#### API endpoints: <br>

| Description | Command                                                         |
| ----------- |-----------------------------------------------------------------|
| Discover registered apps | `curl -H 'Accept: application/json' localhost:8761/eureka/apps \| jq` |


### Elastic Search
Download and run Confluent service (includes kafka, zookeeper, schema registry, etc.)

```console

# Download and run Confluent service (includes kafka, zookeeper, schema registry, etc.)
curl --silent --output docker-compose.yml \
  https://raw.githubusercontent.com/confluentinc/cp-all-in-one/7.0.0-post/cp-all-in-one/docker-compose.yml
docker-compose up -d

# to view container status
docker-compose ps
# or
docker ps

# to stop
docker-compose down

```


To view container status
` docker-compose ps `
or
`docker ps`

To stop containers:
`docker-compose down`


### Testing
Applications which connect to eureka run with a special `test` profile which disables the eureka client. 


## TODO 
- DONE - add trace IDs (sleuth)
- setup E.S. and send logs
- visualize traces in Zipkin
- visualize traces in E.S.
- add security
- dockerize
- hystrix


