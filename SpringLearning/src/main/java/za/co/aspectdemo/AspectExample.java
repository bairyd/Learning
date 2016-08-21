package za.co.aspectdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by DevMachine on 2016/08/21.
 */
@Aspect
@Component
public class AspectExample {
    @Before("execution(* za.co.hello.HelloService.*(..))")
    public void before(JoinPoint jointPoint){
        System.out.println("Before ");
        System.out.println(jointPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* za.co.hello.HelloService.*(..))",returning = "result1")
    public void afterReturn(JoinPoint joinPoint,Object result1){
        System.out.println("Return result = "+joinPoint.getSignature().getName()+ " return= "+result1);
    }

}
