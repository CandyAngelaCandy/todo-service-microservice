package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.HuangYanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.HuangYanyan.todoserice.model.User;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.TodoRepository;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.UserRepository;
import com.thoughtworks.training.HuangYanyan.todoserice.service.TodoService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class todolistTest {

    private final int userId = 1;

    private final User userFixture = new User(userId, "huangyanyan", "password");

    private final int todoId = 1;

    private final TodoItem todoFixture = new TodoItem(todoId, "foo", new Date(),false,false,false,userId,Collections.emptyList());

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
        System.out.println("---------"+toDoRepository.findAllByUserid(userId));
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
