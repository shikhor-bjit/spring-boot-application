package com.example.spring_boot_application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter @Setter
@ConfigurationProperties(prefix = "app")
@PropertySource(value = "classpath:custom.properties")
public class CustomProperties {
    private String custom;
}
