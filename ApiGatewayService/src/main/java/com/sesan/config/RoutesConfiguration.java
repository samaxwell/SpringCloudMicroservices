package com.sesan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("blogs-service", p ->
                        p.path("/blogs/**")
                        // rewrite path from '/blogs/**' to '/**'
                        .filters(f -> f.rewritePath("/blogs/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:9090"))
                .build();
    }
}
