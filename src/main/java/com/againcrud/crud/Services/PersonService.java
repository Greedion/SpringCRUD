package com.againcrud.crud.Services;

import com.againcrud.crud.Entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PersonService {
    ResponseEntity<List<Person>> getAll();
    ResponseEntity<?> getByID(@RequestParam String id);
    ResponseEntity<?> addPerson(@RequestParam Person person);
    ResponseEntity<?> updatePerson(@RequestBody Person person);
    ResponseEntity<?> deleteByID(@RequestParam String id);
}
