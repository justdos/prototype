package starter;

import aop.AopSpringConfig;
import aop.AopTradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopStarter {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopSpringConfig.class);
//        context.getBean(AopTradeService.class).saveTrade();
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean(AopTradeService.class).saveTrade();
    }
}
