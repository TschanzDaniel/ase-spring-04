package edu.spring.database.jpa;

import java.util.List;

import edu.spring.database.model.PersonEntity;


public interface PersonDao {

	public PersonEntity findOne(long id);

	public List<PersonEntity> findAll();

	public void create(PersonEntity entity);

	public PersonEntity update(PersonEntity entity);

	public void delete(PersonEntity entity);

	public void deleteById(long entityId);
}


