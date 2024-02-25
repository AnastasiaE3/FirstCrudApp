package com.example.demo.repository;

import com.example.demo.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Long> {

}

// repo layer acts like DAO (data access object)