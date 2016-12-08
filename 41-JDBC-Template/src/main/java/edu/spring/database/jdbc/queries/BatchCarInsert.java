package edu.spring.database.jdbc.queries;



import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;


public class BatchCarInsert extends BatchSqlUpdate {

    private static final String SQL_INSERT_CAR = "insert into car (model_identification, manufacturer) values (:model_identification, :manufacturer)";

    private static int BATCH_SIZE =  50;

    public BatchCarInsert(DataSource dataSource) {
        super(dataSource, SQL_INSERT_CAR);
        declareParameter(new SqlParameter("model_identification", Types.VARCHAR));
        declareParameter(new SqlParameter("manufacturer", Types.VARCHAR));
        setBatchSize(BATCH_SIZE);
    }

}
