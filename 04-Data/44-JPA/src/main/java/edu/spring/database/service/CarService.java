package edu.spring.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.jpa.CarDao;
import edu.spring.database.model.CarEntity;


@Service
@Transactional(propagation = Propagation.NESTED)
public class CarService {
	
    @Autowired
    private CarDao dao;

    public CarService() {
        super();
    }

    public void create(final CarEntity entity) {
        dao.create(entity);
    }

    public CarEntity update(final CarEntity entity) {
        return dao.update(entity);
    }
    
    public CarEntity findOne(final long id) {
        return dao.findOne(id);
    }

    public List<CarEntity> findAll() {
        return dao.findAll();
    }
}
