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
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("http://user-service:8080/api/users"))

                .route("appointment-service", r -> r.path("/api/appointments/**")
                        .uri("http://appointment-service:8080/api/appointments"))

                .route("medical-record-service", r -> r.path("/api/medical-records/**")
                        .uri("http://medical-record-service:8080/api/medical-records"))

                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://notification-service:8080/api/notifications"))
                .build();
    }
}
