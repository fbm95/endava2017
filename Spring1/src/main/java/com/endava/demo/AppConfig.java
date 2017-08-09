package com.endava.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
//    @Scope("singleton")
    public HelloWorld helloMessage() {
        return new HelloWorld();
    }

    @Bean
    @Scope("singleton")
    public GoodbyeWorld goodbyeMessage() {
        return new GoodbyeWorld();
    }
}