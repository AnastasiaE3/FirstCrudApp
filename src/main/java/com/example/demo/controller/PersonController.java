package com.example.demo.controller;


import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Controller
public class PersonController {
    private PersonSevice service;

@Autowired
    public PersonController(PersonSevice service) {
    this.service = service;
}

    @PostMapping(value = "/create")
    public ResponseEntity<PersonModel> create(@RequestBody PersonModel personModel) {
        return new ResponseEntity<>(service.create(personModel), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<PersonModel> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<PersonModel>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<PersonModel> updateById(
            @PathVariable Long id,
            @RequestBody PersonModel newData) {
        return new ResponseEntity<>(service.update(id, newData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<PersonModel> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}


// main part to talk about








