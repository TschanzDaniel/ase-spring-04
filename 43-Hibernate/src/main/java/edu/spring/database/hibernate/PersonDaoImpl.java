package edu.spring.database.hibernate;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.PersonEntity;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(PersonEntity... personEntity) {
        for (PersonEntity entity : personEntity) {
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
        }
    }
}
