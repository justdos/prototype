package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
//    public LogAspect(String a) {
//
//    }

//    @Pointcut("execution(* *.aop(..))")
    @Pointcut("execution(* aop..*.*(..))")

    public void logPoint(){};

    @Around("logPoint()")
    public void LogAround(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Before Log Record");
            joinPoint.proceed();
            System.out.println("After Log Record");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Around("logPoint()")
    public void LogAround2(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Before Log Record2");
            joinPoint.proceed();
            System.out.println("After Log Record2");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
