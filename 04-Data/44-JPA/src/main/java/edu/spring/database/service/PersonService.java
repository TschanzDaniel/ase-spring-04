package edu.spring.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.jpa.PersonDao;
import edu.spring.database.model.PersonEntity;

@Service
@Transactional(propagation = Propagation.NESTED)
public class PersonService {
    @Autowired
    private PersonDao dao;

    public PersonService() {
        super();
    }

    public void create(final PersonEntity entity) {
        dao.create(entity);
    }

    public PersonEntity update(final PersonEntity entity) {
        return dao.update(entity);
    }
    
    public PersonEntity findOne(final long id) {
        return dao.findOne(id);
    }

    public List<PersonEntity> findAll() {
        return dao.findAll();
    }
}
