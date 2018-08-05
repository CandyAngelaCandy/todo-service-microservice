package com.thoughtworks.training.huangyanyan.todoserice.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.huangyanyan.todoserice.repository.TodoRepository;
import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.huangyanyan.todoserice.model.User;
import com.thoughtworks.training.huangyanyan.todoserice.repository.UserRepository;
import com.thoughtworks.training.huangyanyan.todoserice.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class todolistTest {

    private final int userId = 1;

    private final User userFixture = new User(userId, "huangyanyan", "password");

    private final int todoId = 1;

    private final TodoItem todoFixture = new TodoItem(todoId, "foo", new Date(), false, false, false, userId, Collections.emptyList());

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    //private JwtSinature jwtSignature;

    @MockBean
    private TodoRepository toDoRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private TodoService toDoService;

    @Before
    public void setUp() throws Exception {
        when(toDoRepository.findAllByUserid(userId)).thenReturn(ImmutableList.of(todoFixture));
        System.out.println("---------" + toDoRepository.findAllByUserid(userId));
        when(userRepository.findOne(userId)).thenReturn(userFixture);
        System.out.println(userRepository.findOne(userId));
    }

    @Test
    public void shouldReturn401ForUnauthenticatedRequest() throws Exception {
//        mockMvc.perform(get("/todolist"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].id").value(0))
//                .andExpect(jsonPath("$[0].text").value("foo"))
//                .andReturn();

//        mockMvc.perform(get("/todolist"))
//                .andExpect(unauthenticated());
    }
//
//    @Test
//    public void shouldReturnItemsListWithAuthentication() throws Exception {
//        mockMvc.perform(
//                get("/todolist")
//                        .with(authentication(new UsernamePasswordAuthenticationToken(
//                                userFixture, null, Collections.emptyList()
//                        ))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andExpect(jsonPath("$[0].id").value(todoId))
//                .andExpect(jsonPath("$[0].text").value("foo"));
//    }

}
