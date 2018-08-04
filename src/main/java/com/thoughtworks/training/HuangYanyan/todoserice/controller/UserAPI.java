package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.thoughtworks.training.HuangYanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.service.TodoService;
import com.thoughtworks.training.HuangYanyan.todoserice.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserAPI {
    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @PostMapping("/users")
    public void save(@RequestBody User user){
          userService.save(user);
    }

    @GetMapping("/users")
    public List<User> select(){
        return userService.list();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {

        String userName = user.getName();
        String userPassword = user.getPassword();

        if (userService.verify(userName,userPassword)) {

            String token = userService.generateToken(userName,userPassword);

            return ResponseEntity.ok(token);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users/todolist")
    public List<TodoItem> findTodoByUser(String token){
        User user = userService.findUserByToken(token);
        return todoService.getTodoByUser(user.getName());
    }

}
