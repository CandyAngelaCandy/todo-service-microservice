package com.thoughtworks.training.huangyanyan.todoserice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.huangyanyan.todoserice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;



import java.io.IOException;
import java.util.List;

@RestController
public class TodoAPI {
    @Autowired
    private TodoService todoService = new TodoService();

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public ResponseEntity<List<TodoItem>> todo(Model model) throws IOException {

        List<TodoItem> todoItemList = todoService.list();

        return ResponseEntity.ok(todoItemList);
    }

    @GetMapping(path = "/todos/{id}")
    public TodoItem find(@PathVariable int id) {
//        return Optional.ofNullable(todoService.find(id)).orElseThrow(()->{
//           return new NotFoundException();
//        });

        return todoService.find(id);
    }

    @PostMapping(path = "/todos")
    public void add(@RequestBody TodoItem todoItem) {
        todoService.save(todoItem);
    }

    @DeleteMapping(path = "/todos/{id}")
    public void delete(@PathVariable int id) {
        todoService.delete(id);
    }

    @PostMapping(path = "/todos/{id}")
    public void update(@PathVariable int id, @RequestBody TodoItem todoItem) {
        todoService.update(id, todoItem);
    }

}
