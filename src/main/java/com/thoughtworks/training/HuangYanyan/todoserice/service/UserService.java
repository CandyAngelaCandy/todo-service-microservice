package com.thoughtworks.training.HuangYanyan.todoserice.service;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean verify(String userName, String password) {
//        boolean present = userRepository.findByName(userName).map(User::getPassword).filter(password::equals).isPresent();
//        return present;

        Optional<User> user = userRepository.findByName(userName);
        return user.isPresent() && new BCryptPasswordEncoder().matches(password, user.get().getPassword());

    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void save(User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

    public User getUserByName(String name) {
        User user = userRepository.findByName(name).get();
        return user;
    }

    public String generateToken(String userName,String userPassword) {
        String secretKey = "kitty";

        HashMap<String, Object> claims = new HashMap<>();

        claims.put("name", userName);

        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();

        return token;
    }

    public User findUserByToken(String token) {
        String userName = (String) Jwts.parser().setSigningKey("kitty".getBytes()).parseClaimsJws(token).getBody().get("username");
        return userRepository.findByName(userName).get();
    }
}
