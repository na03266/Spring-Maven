package com.example.demo.config;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.MapUtils;

@Configuration
public class RestTemplateConfig {

    @Value("${api.key}")
    String apiKey;

    //기본적인 빈을 생성하는 법
    @Bean
    public RestTemplate createRestTemplate(){


        RestTemplate restTemplate = new RestTemplate();
        System.out.println(apiKey);

        return restTemplate;
    }
}
