package edu.spring.database.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.spring.database.model.CarEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {

    public List<CarEntity> findByModel(String model);

    @Query("select c from CarEntity c join c.owners p where (p.name = :name)")
    public List<CarEntity> findByOwnerName(@Param("name")String name);

}
