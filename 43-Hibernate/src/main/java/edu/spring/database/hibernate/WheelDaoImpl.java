
package edu.spring.database.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.WheelEntity;

import java.util.List;


@Transactional
@Repository("wheelDao")
public class WheelDaoImpl implements WheelDao {

    @Autowired
    private SessionFactory factory;


    @SuppressWarnings("unchecked")
	@Override
    @Transactional(readOnly = true)
    public List<WheelEntity> getAllWheels() {
        return (List<WheelEntity>)factory.getCurrentSession().getNamedQuery("WheelEntity.getAllWheels").list();
    }

    @Override
    @Transactional(readOnly = true)
    public WheelEntity findById(int id) {
        return (WheelEntity) factory.getCurrentSession().getNamedQuery("WheelEntity.getById").setParameter("id", id).uniqueResult();
    }

    @Override
    public void save(WheelEntity... cars) {
        for (WheelEntity wheelEntity : cars) {
            factory.getCurrentSession().saveOrUpdate(wheelEntity);
        }
    }

    @Override
    public void delete(WheelEntity car) {
        factory.getCurrentSession().delete(car);
    }
}
