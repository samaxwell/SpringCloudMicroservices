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



### TODO 
- add trace IDs (sleuth)
- setup E.S. and send logs
- visualize traces in E.S.
- add security
- dockerize
- hystrix


