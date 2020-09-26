package com.againcrud.crud.Controller;

import com.againcrud.crud.Entity.Person;
import com.againcrud.crud.Services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Qualifier("PersonServiceImpl")
    PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/get")
    ResponseEntity<List<Person>> getAll() {
        return personService.getAll();
    }

    @PutMapping(value = "/getbyid")
    ResponseEntity<?> getByID(@RequestParam String id) {
        return personService.getByID(id);
    }

    @PostMapping(value = "/addperson")
    ResponseEntity<?> addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping(value = "/update")
    ResponseEntity<?> updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping(value = "/delete")
    ResponseEntity<?> deleteByID(@RequestParam String id) {
        return personService.deleteByID(id);
    }

}
