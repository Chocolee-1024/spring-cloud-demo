package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Choco Lee
 */
@Configuration
public class CustomerConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
