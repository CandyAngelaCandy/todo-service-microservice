package com.thoughtworks.training.HuangYanyan.todoserice.service;

import com.thoughtworks.training.HuangYanyan.todoserice.model.TaskItem;
import com.thoughtworks.training.HuangYanyan.todoserice.model.TodoItem;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TodoService {

    @Value(value="classpath:static/data.json")
    private Resource data;

    @Autowired
    TodoRepository todoRepository;

    public String getData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(data.getInputStream()));
        StringBuffer message=new StringBuffer();
        String line = null;
        while((line = br.readLine()) != null) {
            message.append(line);
        }
        String defaultString=message.toString();
        String result=defaultString.replace("\r\n", "").replaceAll(" +", "");
        System.out.println(result);
        return result;
    }

    public List<TodoItem> list(){
        return todoRepository.findAll();
    }

    public TodoItem find(int id) {
        return todoRepository.findOne(id);
    }

    public void save(TodoItem todoItem) {
        todoRepository.save(todoItem);
    }

    public void delete(int id) {
        todoRepository.delete(id);
    }

    public TodoItem update(int id, TodoItem newTodoItem) {
        TodoItem oldTodoItem = todoRepository.findOne(id);
        oldTodoItem.setId(newTodoItem.getId());
        oldTodoItem.setText(newTodoItem.getText());

        todoRepository.save(oldTodoItem);
        return oldTodoItem;
    }
}
