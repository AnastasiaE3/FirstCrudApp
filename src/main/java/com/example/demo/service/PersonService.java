package com.example.demo.service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService (PersonRepository repository) {
        this.repository = repository;
    }

    public PersonModel create(PersonModel person) {
        return repository.save(person);
    }

    public PersonModel readById (long id) {
        return repository.findById(id).get();
    }

    public PersonModel update(Long id, PersonModel newPersonData) {
        PersonModel personInDatabase = this.readById(id);
        personInDatabase.setFirstName(newPersonData.getFirstName());
        personInDatabase.setLastName(newPersonData.getLastName());
        personInDatabase.setBirthDate(newPersonData.getBirthDate());
        personInDatabase = repository.save(personInDatabase);
        return personInDatabase;
    }

    public PersonModel deleteById(Long id) {
        PersonModel personToBeDeleted = this.readById(id);
        repository.delete(personToBeDeleted);
        return personToBeDeleted;
    }

    public List<PersonModel> readAll() {
        Iterable<PersonModel> allPeople = repository.findAll();
        List<PersonModel> personList = new ArrayList<>();
        allPeople.forEach(personList::add);
        return personList;
    }
}