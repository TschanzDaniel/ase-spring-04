package edu.spring.database.jpa;

import java.util.List;

import edu.spring.database.model.CarEntity;

public interface CarDao {

    public List<CarEntity> getAllCars();
    
    public CarEntity findOne(long id);

    public List<CarEntity> findAll();

    public void create(CarEntity entity);

    public CarEntity update(CarEntity entity);

    public void delete(CarEntity entity);

    public void deleteById(long entityId);

}
