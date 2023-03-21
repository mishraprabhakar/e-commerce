package com.sirji.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    //Custom Routing Implemented for all the services
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()

                .route(
                        p -> p.path("/api/product")
                                .uri("lb://PRODUCT-SERVICE")
                )
                .route(
                        p -> p.path("/api/inventory")
                                .uri("lb://INVENTORY-SERVICE")
                )
                .route(
                        p -> p.path("/api/order")
                                .uri("lb://ORDER-SERVICE")
                )
                //Route for eureka server
                .route(
                        p -> p.path("/eureka/web")
                                .filters(f -> f.setPath("/"))
                                .uri("http://localhost:8761")
                )
                //Route for eureka static content such as CSS and all stuff
                .route(
                        p -> p.path("/eureka/**")
                                .uri("http://localhost:8761")
                )
                .build();

    }
}
