package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.thoughtworks.training.HuangYanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.TodoRepository;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;


@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    public UserRepository userRepository;

    @Test
    public void shouldReturnUserWithName() {
//        userRepository.save(new User(0, "xiaohon", "123"));
//
//        Optional<User> user = userRepository.findByName("xiaohong");
//        assertTrue(user.isPresent());
//        assertThat(user.get().getName(),is("xiaohong"));

    }

    @Test
    public void shouldExpectUnauthenticated(){

    }


}
