package com.employees.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.employees.webapp")
@Data
public class CustomProperties {
private String apiUrl;
private String api2URl;
}
