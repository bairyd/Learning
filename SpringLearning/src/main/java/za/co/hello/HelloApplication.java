package za.co.hello;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.config.AppConfig;

/**
 * Created by zubair.davids on 19/08/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class HelloApplication {

    @Autowired
    private HelloService helloServiceImpl;

    @Test
    public void testHelloService(){
        String greeting = helloServiceImpl.goodMorning();
        System.out.println(greeting.toLowerCase());
        assertEquals("Message does not match","Good Morning",greeting);
    }

}
