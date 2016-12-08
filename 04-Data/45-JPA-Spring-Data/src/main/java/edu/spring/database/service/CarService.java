package edu.spring.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.CarEntity;
import edu.spring.database.repository.CarRepository;


@Service
@Transactional(propagation = Propagation.NESTED)
public class CarService {
	
    @Autowired
    private CarRepository repository;

    public CarService() {
        super();
    }


    public CarEntity save(final CarEntity entity) {
        return repository.save(entity);
    }
    
    public CarEntity findOne(final Integer id) {
        return repository.findOne(id);
    }

    public Iterable<CarEntity> findAll() {
        return repository.findAll();
    }
    
    public List<CarEntity> findByModel(final String model) {
        return repository.findByModel(model);
    }
    
    public List<CarEntity> findByOwnerName(final String owner) {
        return repository.findByOwnerName(owner);
    }
    
}
