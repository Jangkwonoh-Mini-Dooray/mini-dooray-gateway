package com.nhnacademy.minidooraygateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "backend.server")
public class UrlProperties {
    private String account1Url;
    private String account2Url;
    private String task1Url;
    private String task2Url;
}
