package com.thoughtworks.training.HuangYanyan.todoserice.service;

import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean verify(String userName, String password) {
        boolean present = userRepository.findByName(userName).map(User::getPassword).filter(password::equals).isPresent();
        return present;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
