package com.thoughtworks.training.huangyanyan.todoserice.service;

import com.thoughtworks.training.huangyanyan.todoserice.repository.PersonRepository;
import com.thoughtworks.training.huangyanyan.todoserice.model.Person;
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
