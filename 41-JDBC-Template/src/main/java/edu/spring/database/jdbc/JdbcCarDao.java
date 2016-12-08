package edu.spring.database.jdbc;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.spring.database.jdbc.queries.BatchCarInsert;
import edu.spring.database.jdbc.queries.SelectAllCars;
import edu.spring.database.model.Car;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcCarDao {

    private JdbcTemplate template;
    private SelectAllCars selectAllCars;
    private BatchCarInsert batchCarInsert;

    private void configure() {
        template.execute("create table car(id int auto_increment primary key, model_identification varchar(20), manufacturer varchar(20))");
    }

    @Autowired
    private void setDataSource(DataSource dataSource) {
        //DataSource dataSource1 = dataSource;
        this.template = new JdbcTemplate(dataSource);
        this.selectAllCars = new SelectAllCars(dataSource);
        this.batchCarInsert = new BatchCarInsert(dataSource);
        configure();
    }

    public Car findCarById(int id)  {
        List<Car> result = template.query(String.format("select id, model_identification, manufacturer from car where (id = %s)", id), new RowMapper<Car>() {
            @Override
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model_identification"));
                car.setManufacturer(resultSet.getString("manufacturer"));
                return car;
            }
        });
        if (result.size() > 0) return result.get(0);
        else return null;
    }

    public void saveCar(Car... cars) {
        Map<String, String> parameterMap = new HashMap<String, String>(3);
        for (Car car : cars) {
            parameterMap.put("manufacturer", car.getManufacturer());
            parameterMap.put("model_identification", car.getModel());

            batchCarInsert.updateByNamedParam(parameterMap);
            parameterMap.clear();
        }
        batchCarInsert.flush();
    }

    public List<Car> findAllCars() {
        return selectAllCars.execute();
    }


}
