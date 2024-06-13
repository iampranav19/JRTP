package com.pranav.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "plan.module")
public class AppConfigProperties {
    private Map<String, String> messages;
}
