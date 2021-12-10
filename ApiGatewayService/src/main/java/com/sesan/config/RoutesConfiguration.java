package com.sesan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
//                .route(r -> r.path("/employee/**")
                .route(r ->  r.path("/blogs/**")
                        .uri("http://localhost:9090")
                )
                .build();
    }
}
