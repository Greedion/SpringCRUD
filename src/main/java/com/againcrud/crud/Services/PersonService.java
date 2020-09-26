package com.againcrud.crud.Services;
import com.againcrud.crud.Entity.Person;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface PersonService {
    ResponseEntity<List<Person>> getAll();
    ResponseEntity<?> getByID(String id);
    ResponseEntity<?> addPerson(Person person);
    ResponseEntity<?> updatePerson(Person person);
    ResponseEntity<?> deleteByID(String id);
}
