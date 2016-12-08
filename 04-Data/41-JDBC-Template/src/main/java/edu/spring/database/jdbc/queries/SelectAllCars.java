package edu.spring.database.jdbc.queries;

import org.springframework.jdbc.object.MappingSqlQuery;
import edu.spring.database.model.Car;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllCars extends MappingSqlQuery<Car> {

    private static final String SQL_SELECT_ALL_CARS = "SELECT * FROM CAR";

    public SelectAllCars(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_CARS);
    }

    @Override
    protected Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car =  new Car(resultSet.getString("model_identification"), resultSet.getString("manufacturer"));
        car.setId(resultSet.getInt("id"));
        return car;
    }
}
