package za.co.hello;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.config.AppConfig;
import za.co.db.DataSourceZub;
import za.co.db.PersonDao;
import za.co.db.PersonDto;

import java.util.List;

/**
 * Created by zubair.davids on 19/08/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class HelloApplication {

    @Autowired
    private HelloService helloServiceImpl;

    @Autowired
    private PersonDao personDao;

    @Test
    public void testHelloService(){
        String greeting = helloServiceImpl.goodMorning();
        System.out.println(greeting.toLowerCase());
        assertEquals("Message does not match","Good Morning",greeting);

        PersonDto personDto = new PersonDto();
        personDao.insetPerson(personDto);
        List<PersonDto> people = personDao.getPeople();
        for (PersonDto dto : people){
            System.out.println("Firstname: "+dto.getFirstName());
        }
    }

}
