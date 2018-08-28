package com.thoughtworks.training.huangyanyan.todoserice.service;

import com.thoughtworks.training.huangyanyan.todoserice.dto.User;
import com.thoughtworks.training.huangyanyan.todoserice.model.TaskItem;
import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.huangyanyan.todoserice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class TodoService {

    @Value(value = "classpath:static/data.json")
    private Resource data;

    @Autowired
    TodoRepository todoRepository;

    public List<TodoItem> list() {
        User user= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<TodoItem> todoItems = todoRepository.findAllByUserid(user.getId());

        return todoItems;
    }

    public TodoItem find(int id) {
        User user= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<TodoItem> todoItems = todoRepository.findAllByUserid(user.getId());

        return todoItems.stream().filter((todoItem) -> todoItem.getId() == id).findFirst().orElse(null);
    }

    public void save(TodoItem todoItem) {
        todoRepository.save(todoItem);
    }

    public void delete(int id) {
        todoRepository.delete(id);
    }

    public TodoItem update(int id, TaskItem newTaskItem) {
        User user= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<TodoItem> todoItems = todoRepository.findAllByUserid(user.getId());

        TodoItem todoItemById = todoItems.stream().filter((todoItem) -> todoItem.getId() == id).findFirst().orElse(null);

        List<TaskItem> taskItems = todoItemById.getTaskItems();

        newTaskItem.setTodoItem(todoItemById);

        taskItems.add(newTaskItem);


        todoItemById.setTaskItems(taskItems);

        todoRepository.save(todoItemById);
        return todoItemById;
    }
}
