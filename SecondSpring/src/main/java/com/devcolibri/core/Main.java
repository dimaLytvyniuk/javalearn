package com.devcolibri.core;

import com.devcolibri.config.BeenConfig;
import com.devcolibri.hello.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dima on 21.06.17.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeenConfig.class);
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");

        obj.sayHelloWorldImpl("Hello World and DevColibri.com!");

    }
}
