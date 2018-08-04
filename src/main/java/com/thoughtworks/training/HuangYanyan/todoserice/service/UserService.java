package com.thoughtworks.training.HuangYanyan.todoserice.service;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import io.jsonwebtoken.Jwts;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean verify(String userName, String password) {

        boolean present = userRepository.findByName(userName).map(User::getPassword).filter(password::equals).isPresent();
        return present;

    }

    public List<User> list(){
        return userRepository.findAll();
    }

    public void save(User user) {
         userRepository.save(user);
    }

    public String generateToken(String userName) {
        User user = userRepository.findByName(userName).get();

        String secretKey = "kitty";

        HashMap<String, Object> claims = new HashMap<>();

        System.out.println(user.getId());
        ;
        claims.put("userId", user.getId());

        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();

        return token;
    }
}
