package com.thoughtworks.training.huangyanyan.todoserice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.huangyanyan.todoserice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

@Controller
public class TodoCtroller {

    @Autowired
    private TodoService todoService = new TodoService();

    @RequestMapping(method = RequestMethod.GET, path = "/todo")
    public String todo(Model model) throws IOException {

        // model.addAttribute("todoList",todoService.list());

        String json = todoService.getData();
        System.out.println("json数据" + json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<TodoItem> list = objectMapper.readValue(json,
                new TypeReference<List<TodoItem>>() {
                }
        );
        System.out.println(list);

        model.addAttribute("todoList", list);

        return "todo";

    }

}
