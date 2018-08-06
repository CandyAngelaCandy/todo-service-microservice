package com.thoughtworks.training.huangyanyan.todoserice.repository;

import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Integer> {
    List<TodoItem> findAllByUserid(int userId);
}

