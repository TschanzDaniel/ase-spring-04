package edu.spring.database.jpa;


import org.springframework.stereotype.Repository;

import edu.spring.database.model.PersonEntity;

@Repository
public class PersonDaoImpl extends AbstractJpaDAO<PersonEntity> implements PersonDao{

	public PersonDaoImpl() {
		super(PersonEntity.class);
	}
}
