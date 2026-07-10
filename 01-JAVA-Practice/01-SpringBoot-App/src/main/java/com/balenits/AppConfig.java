package com.balenits;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig :: Constructor");
    }

    @Bean
    public RestTemplate createInstance(){
        System.out.println("RestTemplate :: Bean Obj created");
        return new RestTemplate();
    }
}
