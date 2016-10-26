package za.co.db;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by DevMachine on 2016/08/21.
 */
public class DataSourceZub {
    private EmbeddedDatabase database;
    public DataSource getDataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        database = builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("db_create.sql")
                .build();
        return database;
    }

    public void shutdown(){
        database.shutdown();
    }

}