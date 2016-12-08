package edu.spring.database.hibernate;

import edu.spring.database.model.PersonEntity;

public interface PersonDao {

    public void save(PersonEntity... personEntity);
    
}
