package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private UserService userService = new UserService();

    @PostMapping("/users")
    public void save(@RequestBody User user){
          userService.save(user);
    }


    @GetMapping("/users")
    public List<User> select(){
        return userService.list();
    }
}
