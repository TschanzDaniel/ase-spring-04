package edu.spring.database.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.CarEntity;

import java.util.List;


@Transactional
@Repository("carDao")
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory factory;


    @SuppressWarnings("unchecked")
	@Override
    @Transactional(readOnly = true)
    public List<CarEntity> getAllCars() {
        return (List<CarEntity>)factory.getCurrentSession().getNamedQuery("CarEntity.getAllCars").list();
    }

    @Override
    @Transactional(readOnly = true)
    public CarEntity findById(int id) {
        return (CarEntity) factory.getCurrentSession().getNamedQuery("CarEntity.getById").setParameter("id", id).uniqueResult();
    }

    @Override
    public void save(CarEntity... cars) {
        for (CarEntity carEntity : cars) {
            factory.getCurrentSession().saveOrUpdate(carEntity);
        }
    }

    @Override
    public void delete(CarEntity car) {
        factory.getCurrentSession().delete(car);
    }
}
