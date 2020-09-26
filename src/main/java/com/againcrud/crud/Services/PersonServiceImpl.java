package com.againcrud.crud.Services;
import com.againcrud.crud.Entity.Person;
import com.againcrud.crud.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {


    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getByID(String id) {
        if (id != null && !id.equals("")) {
            Optional<Person> obj = personRepository.findById(Long.parseLong(id));
            if (obj.isPresent())
                return ResponseEntity.ok(obj.get());
            else
                return ResponseEntity.badRequest().body("Record not found");
        }
        return ResponseEntity.badRequest().body("Requested param can't be null.");
    }

    @Override
    public ResponseEntity<?> addPerson(Person person) {
        if (person != null && person.getName() != null && !person.getName().equals("") && person.getSurname() != null && !person.getSurname().equals("")) {
            Optional<Person> obj = Optional.ofNullable(personRepository.findByNameAndSurname(person.getName(), person.getSurname()));
            if (obj.isPresent())
                return ResponseEntity.badRequest().body("Record already exist");
            else {
                personRepository.save(person);
                return ResponseEntity.ok().body("Added");
            }
        }
        return ResponseEntity.badRequest().body("Requested param can't be null.");
    }

    @Override
    public ResponseEntity<?> updatePerson(Person person) {
        if (person != null && person.getName() != null
                && !person.getName().equals("") && person.getSurname()
                != null && !person.getSurname().equals("") && person.getId() != null) {
            Optional<Person> obj = personRepository.findById(person.getId());
            if (obj.isPresent()) {
                personRepository.save(person);
                return ResponseEntity.ok().body("Updated");
            } else
                return ResponseEntity.badRequest().body("Record don't exist");
        }
        return ResponseEntity.badRequest().body("Requested param's can't be nullable");
    }

    @Override
    public ResponseEntity<?> deleteByID(String id) {
        if (id != null && !id.equals("")) {
            Optional<Person> obj = personRepository.findById(Long.parseLong(id));
            if (obj.isPresent()) {
                personRepository.deleteById(Long.parseLong(id));
                return ResponseEntity.ok().body("Deleted");
            } else
                return ResponseEntity.badRequest().body("Record don't exist");
        }
        return ResponseEntity.badRequest().body("Requested param can't be null");

    }
}
