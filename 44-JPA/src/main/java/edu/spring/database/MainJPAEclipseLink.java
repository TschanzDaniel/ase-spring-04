package edu.spring.database;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.jpa.CarDao;
import edu.spring.database.model.CarEntity;

public class MainJPAEclipseLink {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("jpa-config-el.xml");
        CarDao carDao = context.getBean(CarDao.class);

        for (CarEntity car : carDao.getAllCars()) {
        	car.getOwners().size();
            System.out.println(car);
        }
        context.close();
    }

}
