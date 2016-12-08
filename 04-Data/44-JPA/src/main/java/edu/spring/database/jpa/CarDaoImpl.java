package edu.spring.database.jpa;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.CarEntity;

import java.util.List;


@Repository
public class CarDaoImpl extends AbstractJpaDAO<CarEntity>  implements CarDao {

	public CarDaoImpl() {
		super(CarEntity.class);
	}

    @Override
    @Transactional(readOnly = true)
    public List<CarEntity> getAllCars() {
        return entityManager.createNamedQuery("CarEntity.getAllCars", CarEntity.class).getResultList();
    }


}
