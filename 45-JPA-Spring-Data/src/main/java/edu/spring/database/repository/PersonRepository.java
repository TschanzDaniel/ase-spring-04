package edu.spring.database.repository;



import org.springframework.data.repository.CrudRepository;

import edu.spring.database.model.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}
