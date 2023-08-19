package com.example.demo.config;

import com.example.demo.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.PersonRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;



@Configuration
public class PersonConfig {
    @Autowired
    private PersonRepository repository;


    @PostConstruct
    public void setup() {
        PersonModel person1 = new PersonModel();
        person1.setFirstName("Dean");
        person1.setLastName("Walls");

        PersonModel person2 = new PersonModel();
        person2.setFirstName("Nastya");
        person2.setLastName("Epifinova");

        repository.saveAll(Arrays.asList(
                person1,
                person2
        ));

    }
}



