package com.thoughtworks.training.HuangYanyan.todoserice.service;

import com.thoughtworks.training.HuangYanyan.todoserice.model.Person;
import com.thoughtworks.training.HuangYanyan.todoserice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    public Person find(String name) {

        PersonRepository personRepository = new PersonRepository();

        List<Person> persons = personRepository.list();

        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .get();
    }
}
