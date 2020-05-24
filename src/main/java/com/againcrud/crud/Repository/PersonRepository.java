package com.againcrud.crud.Repository;

import com.againcrud.crud.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByNameAndSurname(String name, String surname);

}
