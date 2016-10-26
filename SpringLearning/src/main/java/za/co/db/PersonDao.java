package za.co.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DevMachine on 2016/08/21.
 */
@Component
public class PersonDao {

    private DataSourceZub dataSourceZub;

    private JdbcTemplate jdbcTemplate;

    public PersonDao() {
        dataSourceZub = new DataSourceZub();
        this.jdbcTemplate = new JdbcTemplate(dataSourceZub.getDataSource());
    }

    public void insetPerson(PersonDto personDto){
        jdbcTemplate.update("insert into person (ID,FIRSTNAME,SURNAME,AGE) VALUES (:ID,:firstName,:surname,:age)",new BeanPropertySqlParameterSource(personDto));
    }

    public PersonDto getPerson (){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON",PersonDto.class);
    }

    public List<PersonDto> getPeople(){
        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper(PersonDto.class));
    }

    public void shutdown(){
        dataSourceZub.shutdown();
    }
}
