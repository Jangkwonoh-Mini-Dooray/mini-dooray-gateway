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
    private String accountUrl1;
    private String accountUrl2;
    private String taskUrl1;
    private String taskUrl2;
}
