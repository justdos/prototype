package bean;

import annotion.Autowire;
import annotion.MyBean;

@MyBean
public class GuestBean {
    @Autowire
    OrderBean orderBean;
}
