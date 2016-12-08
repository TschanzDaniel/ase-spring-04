
package edu.spring.database;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.spring.database.jdbc.JdbcCarDao;
import edu.spring.database.model.Car;

public class MainJDBCTemplate {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("jdbc-config.xml");

        JdbcCarDao carDao = context.getBean(JdbcCarDao.class);

        carDao.saveCar(
                new Car("R8", "Audi"),
                new Car("A3", "Audi")
        );

        for (Car car : carDao.findAllCars()) {
            System.out.println(car);
        }
        
        context.close();
    }

}
