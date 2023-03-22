package starter;

import IoC.BeanFactory;
import IoC.MyConfigClasss;
import IoC.MySpringContext;
import bean.MyBean1;

public class MySpringStart {
    public static void main(String[] args) throws Exception {
        MySpringContext context = new MySpringContext(MyConfigClasss.class);
        System.out.println(BeanFactory.beanMap);
    }
}
