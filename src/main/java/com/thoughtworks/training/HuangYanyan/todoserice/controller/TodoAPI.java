package com.thoughtworks.training.HuangYanyan.todoserice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.HuangYanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.HuangYanyan.todoserice.service.TodoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoAPI {
    @Autowired
    private TodoService todoService = new TodoService();

    @RequestMapping(method = RequestMethod.GET, path = "/todolist")
    public List<TodoItem> todo(Model model) throws IOException {

        String json = todoService.getData();
        System.out.println("json数据" + json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<TodoItem> list = objectMapper.readValue(json,
                new TypeReference<List<TodoItem>>() {
                }
        );

        System.out.println(list);

        return todoService.list();
        //return todoService.getTodoByUser();

        //return list;
    }

    @GetMapping(path = "/todolist/{id}")
    public TodoItem find(@PathVariable int id) {
//        return Optional.ofNullable(todoService.find(id)).orElseThrow(()->{
//           return new NotFoundException();
//        });

        return todoService.find(id);
    }

    @PostMapping(path = "/todolist")
    public void add(@RequestBody TodoItem todoItem) {
        todoService.save(todoItem);
    }

    @DeleteMapping(path = "/todolist/{id}")
    public void delete(@PathVariable int id){
        todoService.delete(id);
    }

    @PostMapping(path = "/todolist/{id}")
     public void update(@PathVariable  int id,@RequestBody TodoItem todoItem){
        todoService.update(id,todoItem);
    }

}
