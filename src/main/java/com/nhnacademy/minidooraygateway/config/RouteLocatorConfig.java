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
                .route("mini-dooray-account-api-1",
                        p -> p.path("/members/**").and()
                                .weight("mini-dooray-account-api", 50)
                                .uri(urlProperties.getAccount1Url())
                )
                .route("mini-dooray-account-api-2",
                        p -> p.path("/members/**").and()
                                .weight("mini-dooray-account-api", 50)
                                .uri(urlProperties.getAccount2Url())
                )
                .route("mini-dooray-task-api-1",
                        p -> p.path("/task/**",
                                        "/mentions/**",
                                        "/milestones/**",
                                        "/projects/**",
                                        "/project-authority/**",
                                        "/project-status").and()
                                .weight("mini-dooray-task-api", 50)
                                .uri(urlProperties.getTask1Url())
                )
                .route("mini-dooray-task-api-2",
                        p -> p.path("/task/**",
                                        "/mentions/**",
                                        "/milestones/**",
                                        "/projects/**",
                                        "/project-authority/**",
                                        "/project-status").and()
                                .weight("mini-dooray-task-api", 50)
                                .uri(urlProperties.getTask2Url())
                )
                .build();
    }

}
