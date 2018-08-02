package com.thoughtworks.training.HuangYanyan.todoserice.repository;

import com.thoughtworks.training.HuangYanyan.todoserice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    public List<Person> list(){
        List<Person> list = new ArrayList<Person>(){{
            add(new Person("hh","xian"));
            add(new Person("xx","xian"));
        }};
        return list;
    }
}
