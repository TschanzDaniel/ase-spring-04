package edu.spring.database.config;



import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.database.hibernate.CarDao;
import edu.spring.database.hibernate.PersonDao;
import edu.spring.database.model.Address;
import edu.spring.database.model.CarEntity;
import edu.spring.database.model.PersonEntity;
import edu.spring.database.model.WheelEntity;

import java.util.Arrays;
import java.util.List;

@Repository
public class Configuration implements InitializingBean {

	@Autowired
	CarDao carDao;

	@Autowired
	PersonDao personDao;

	private List<WheelEntity> provideWheels() {
		return Arrays.asList(
				new WheelEntity(),
				new WheelEntity(),
				new WheelEntity(),
				new WheelEntity()
				);
	}

	private void configureDatabase() {
		System.out.println("Konfiguriere Datenbank..");

		// Autos anlegen
		CarEntity r8 = new CarEntity("R8", provideWheels());
		CarEntity m3 = new CarEntity("M3", provideWheels());

		for (WheelEntity wheel : r8.getWheels()) {
			wheel.setCar(r8);
		}
		for (WheelEntity wheel : m3.getWheels()) {
			wheel.setCar(m3);
		}
		
		
		carDao.save(r8, m3);

		// Personen anlegen
		PersonEntity personEntity = new PersonEntity("Felix", new Address("Musterstrasse", 2), Arrays.asList(r8, m3));
		personDao.save(personEntity);

		System.out.println("Konfiguration abgeschlossen");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		configureDatabase();
	}
}
