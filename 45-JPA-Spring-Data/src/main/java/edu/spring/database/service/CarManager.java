package edu.spring.database.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.database.model.CarEntity;
import edu.spring.database.repository.CarRepository;

@Component
@Transactional
public class CarManager {

    @Autowired
    CarRepository repository;

    public void manage()
    {
        System.out.println("Finding Car by Model Name: R8");
        for (CarEntity carEntity : repository.findByModel("R8")) {
            System.out.println(carEntity);
        }

        System.out.println("Finding Cars of Owner: Felix");
        for (CarEntity carEntity : repository.findByOwnerName("Felix")) {
            System.out.println(carEntity);
        }
    }

}
