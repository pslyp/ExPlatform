package com.training.platform.configs;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeLeafConfig {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
