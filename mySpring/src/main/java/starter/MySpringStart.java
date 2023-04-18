package starter;

import IoC.BeanFactory;
import IoC.MyConfigClasss;
import IoC.MySpringContext;
import aop.AopTradeService;
import bean.AopInterface;
import bean.MyAopBean;
import bean.MyBean1;

public class MySpringStart {
    public static void main(String[] args) throws Exception {
        MySpringContext context = new MySpringContext(MyConfigClasss.class);
        AopInterface bean = (AopInterface)BeanFactory.getBean("bean.MyAopBean");
        bean.saveTrade();
//        System.out.println(BeanFactory.beanMap);
    }
}
