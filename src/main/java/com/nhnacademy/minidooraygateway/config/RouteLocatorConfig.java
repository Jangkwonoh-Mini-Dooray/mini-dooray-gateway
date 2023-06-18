package com.nhnacademy.minidooraygateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RouteLocatorConfig {
    private final UrlProperties urlProperties;
    @Bean
    public RouteLocator miniDoorayRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("mini-dooray-account-api",
                        p -> p.path("/members/**")
                                .uri(urlProperties.getAccountUrl())
                )
                .route("mini-dooray-task-api",
                        p -> p.path("/task/**",
                                        "/mentions/**",
                                        "/milestones/**",
                                        "/projects/**",
                                        "/project-authority/**",
                                        "/project-status")
                                .uri(urlProperties.getTaskUrl())
                )
                .build();
    }

}