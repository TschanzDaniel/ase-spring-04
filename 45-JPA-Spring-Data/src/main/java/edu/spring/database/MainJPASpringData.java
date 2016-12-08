package edu.spring.database;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.service.CarManager;

public class MainJPASpringData {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-data-config-hi.xml");
        CarManager manager = context.getBean(CarManager.class);

        manager.manage();

        context.close();
    }
}
