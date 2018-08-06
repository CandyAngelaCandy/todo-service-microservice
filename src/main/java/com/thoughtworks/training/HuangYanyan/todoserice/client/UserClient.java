package com.thoughtworks.training.huangyanyan.todoserice.client;

import com.thoughtworks.training.huangyanyan.todoserice.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", url = "http://localhost:8080")
public interface UserClient {

    @PostMapping("api/users/verifications")
    User verifyToken(@RequestBody String token);
}
