package edu.spring.database;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.hibernate.CarDao;
import edu.spring.database.hibernate.WheelDao;
import edu.spring.database.model.CarEntity;
import edu.spring.database.model.WheelEntity;


public class MainHibernate {

    public static void main(String[] args) {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("hibernate-config.xml");

    	
        WheelDao wheelDao = context.getBean(WheelDao.class);
        for (WheelEntity wheel : wheelDao.getAllWheels()) {
            System.out.println(wheel);
        }
        
    	CarDao carDao = context.getBean(CarDao.class);

        for (CarEntity car : carDao.getAllCars()) {
            System.out.println(car);
        }
        
        
        context.close();
    }

}
