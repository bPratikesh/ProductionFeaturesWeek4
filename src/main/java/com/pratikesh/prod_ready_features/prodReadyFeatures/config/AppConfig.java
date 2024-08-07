package com.pratikesh.prod_ready_features.prodReadyFeatures.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
     ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
