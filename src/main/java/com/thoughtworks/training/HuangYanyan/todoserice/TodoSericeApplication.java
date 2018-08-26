package com.thoughtworks.training.huangyanyan.todoserice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.retry.annotation.EnableRetry;

//@EnableRetry
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
public class TodoSericeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoSericeApplication.class, args);
    }
}
