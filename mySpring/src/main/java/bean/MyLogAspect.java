package bean;

import annotion.MyAroundAOP;
import annotion.MyAspect;
import annotion.MyBean;
import aop.MyProceedingJoinPoint;

@MyAspect
@MyBean
public class MyLogAspect {
    @MyAroundAOP
    private void aroundMethod(MyProceedingJoinPoint point) {
        System.out.println("My Spring Aop Before Invoke");
        point.invoke();
        System.out.println("My Spring Aop Before Invoke");

    }
}
