package za.co.hello.impl;

import org.springframework.stereotype.Component;
import za.co.hello.HelloService;

/**
 * Created by zubair.davids on 19/08/2016.
 */
@Component
public class HelloServiceImpl implements HelloService {
    public String goodMorning() {
        return "Good Morning";
    }

    public String goodNight() {
        return "Good Night";
    }
}
