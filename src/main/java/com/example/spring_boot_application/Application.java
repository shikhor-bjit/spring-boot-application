package com.example.spring_boot_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public Application(CustomProperties customProperties) {
        System.out.println("custom value: " + customProperties.getCustom());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
