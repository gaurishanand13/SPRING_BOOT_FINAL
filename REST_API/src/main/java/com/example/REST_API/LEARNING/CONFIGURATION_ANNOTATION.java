package com.example.REST_API.LEARNING;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CONFIGURATION_ANNOTATION {

    @Bean
    public CHILDREN getChildren(){
        return new CHILDREN();
    }
}
