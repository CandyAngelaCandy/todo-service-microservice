package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public void save(@RequestBody User user){
        System.out.println(user+"user ");
          userService.save(user);
    }

    @GetMapping("/users")
    public List<User> select(){
        return userService.list();
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        String userName = user.getName();
        String userPassword = user.getPassword();

        if (userService.verify(userName, userPassword)) {

            String token = userService.generateToken(userName);

            return ResponseEntity.ok(token);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
