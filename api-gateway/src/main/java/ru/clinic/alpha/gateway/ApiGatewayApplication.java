package ru.clinic.alpha.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .uri("lb://USER-SERVICE"))
                .route("appointment-service", r -> r.path("/appointments/**")
                        .uri("lb://APPOINTMENT-SERVICE"))
                .route("medical-record-service", r -> r.path("/medical-records/**")
                        .uri("lb://MEDICAL-RECORD-SERVICE"))
                .route("notification-service", r -> r.path("/notifications/**")
                        .uri("lb://NOTIFICATION-SERVICE"))
                .build();
    }
}
