package com.thoughtworks.training.huangyanyan.todoserice.client;

import com.thoughtworks.training.huangyanyan.todoserice.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", url = "http://localhost:8081")
public interface UserClient {

    @PostMapping("/verifications")
    ResponseEntity verifyToken(@RequestBody String token);
}
