package com.thoughtworks.training.huangyanyan.todoserice.service;

import com.thoughtworks.training.huangyanyan.todoserice.model.User;
import com.thoughtworks.training.huangyanyan.todoserice.repository.UserRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import io.jsonwebtoken.Jwts;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean verify(String userName, String password) {

//        boolean present = userRepository.findByName(userName).map(User::getPassword).filter(password::equals).isPresent();

        User user = userRepository.findByName(userName).get();

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException(String.format("wrong password"));
        }

        return true;

    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void save(User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

    public String generateToken(String userName) {
        User user = userRepository.findByName(userName).get();

        String secretKey = "kitty";

        HashMap<String, Object> claims = new HashMap<>();

        System.out.println(user.getId());

        claims.put("userId", user.getId());

        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes(Charset.forName("UTF-8")))
                .compact();

        return token;
    }
}
