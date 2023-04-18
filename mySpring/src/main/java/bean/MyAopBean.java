package bean;

import annotion.MyBean;

import java.io.Serializable;

@MyBean
public class MyAopBean implements AopInterface {
    public void saveTrade(){
        System.out.println("save trade successful");
    }
}
