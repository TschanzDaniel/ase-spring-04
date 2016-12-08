package edu.spring.database.config;



import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.Address;
import edu.spring.database.model.CarEntity;
import edu.spring.database.model.PersonEntity;
import edu.spring.database.model.WheelEntity;
import edu.spring.database.service.CarService;
import edu.spring.database.service.PersonService;

import java.util.Arrays;
import java.util.List;

@Transactional
public class Configuration implements InitializingBean {

	@Autowired
	CarService carService;

	@Autowired
	PersonService personService;

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

		// Fahrzeuge speichern
		//carService.save(r8);
		//carService.save(m3);

		// Personen anlegen
		PersonEntity personEntity = new PersonEntity("Felix", new Address("Musterstrasse", 2), Arrays.asList(r8, m3));
		personService.save(personEntity);

		System.out.println("Konfiguration abgeschlossen");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		configureDatabase();
	}
}
