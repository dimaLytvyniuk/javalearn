package com.devcolibri.config;

import com.devcolibri.hello.HelloWorld;
import com.devcolibri.hello.impl.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dima on 21.06.17.
 */
@Configuration
public class BeenConfig {
    @Bean(name = "helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
}
