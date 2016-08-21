package za.co.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zubair.davids on 19/08/2016.
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"za.co.hello","za.co.aspectdemo"})
public class AppConfig {
}
