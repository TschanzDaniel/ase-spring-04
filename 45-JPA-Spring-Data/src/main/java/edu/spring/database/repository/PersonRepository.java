package edu.spring.database.repository;



import org.springframework.data.repository.CrudRepository;

import edu.spring.database.model.PersonEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}
