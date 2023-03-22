package start;

import bean.Cat;
import bean.TradeService;
import config.SpringCofiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStarter {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringCofiguration.class);
        Cat bean = context.getBean(Cat.class);
        TradeService tradeService = (TradeService)context.getBean("tradeService");
        tradeService.saveTrade();
    }
}
