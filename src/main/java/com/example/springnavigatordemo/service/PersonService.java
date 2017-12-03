package com.example.springnavigatordemo.service;

import com.example.springnavigatordemo.model.Person;
import com.example.springnavigatordemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    final private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllPersons(){
        return new ArrayList<>(repository.findAll());
    }
}
