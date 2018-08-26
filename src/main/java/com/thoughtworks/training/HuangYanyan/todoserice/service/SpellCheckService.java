package com.thoughtworks.training.huangyanyan.todoserice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoughtworks.training.huangyanyan.todoserice.model.TodoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SpellCheckService {

    @Autowired
    SpellChecker spellChecker;

    @HystrixCommand(fallbackMethod = "checkSpellFallback")
    public List<TodoItem> checkSpell(List<TodoItem> todoItems){
        spellChecker.check(todoItems,TodoItem::getText,TodoItem::setSuggestion);
        return todoItems;
    }

    public List<TodoItem> checkSpellFallback(List<TodoItem> todoItems){
        log.info("checkFallback");
        return todoItems;
    }


//    @Retryable(maxAttempts = 2, backoff = @Backoff(20))
//    public List<TodoItem> retryService(List<TodoItem> todoItems){
//        spellChecker.check(todoItems,TodoItem::getText,TodoItem::setSuggestion);
//        return todoItems;
//    }

//    @Recover
//    List<TodoItem> recover(RuntimeException e,List<TodoItem> todoItems){
//        return todoItems;
//    }
}
