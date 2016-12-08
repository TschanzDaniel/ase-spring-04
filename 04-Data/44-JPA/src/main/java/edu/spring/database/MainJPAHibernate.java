package edu.spring.database;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.jpa.CarDao;
import edu.spring.database.model.CarEntity;

public class MainJPAHibernate {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("jpa-config-hi.xml");
        CarDao carDao = context.getBean(CarDao.class);

        for (CarEntity car : carDao.getAllCars()) {
            System.out.println(car);
        }
        context.close();
    }
}
