package aop;

import annotion.MyBean;
import org.springframework.stereotype.Component;

@Component
@MyBean
public class AopTradeService {
    public void saveTrade(){
        System.out.println("save trade successful");
    }
}
