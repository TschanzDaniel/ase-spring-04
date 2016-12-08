package edu.spring.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.PersonEntity;
import edu.spring.database.repository.PersonRepository;

@Service
@Transactional(propagation = Propagation.NESTED)
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public PersonService() {
        super();
    }

     public PersonEntity save(final PersonEntity entity) {
        return repository.save(entity);
    }
    
    public PersonEntity findOne(final Integer id) {
        return repository.findOne(id);
    }
    
    public PersonEntity findOne(final Long id) {
        return repository.findOne((int)(long)id);
    }


    public Iterable<PersonEntity> findAll() {
        return repository.findAll();
    }
}
