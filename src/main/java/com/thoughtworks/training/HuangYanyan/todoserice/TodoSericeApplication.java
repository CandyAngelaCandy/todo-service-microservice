package com.thoughtworks.training.huangyanyan.todoserice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TodoSericeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoSericeApplication.class, args);
    }
}
