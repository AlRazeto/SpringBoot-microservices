package com.microservicios.Gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routingConfig (RouteLocatorBuilder builder){
        return builder.routes()
                .route(x-> x.path("/change/**")
                    .uri("lb://currency-change")
                )
                .route(x-> x.path("/exchange/**")
                    .uri("lb://currency-exchange")
                )
                .build();
    }
}
