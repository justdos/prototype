package bean;

import annotion.Autowire;
import annotion.MyBean;

@MyBean
public class GiftBean {
    @Autowire
    GuestBean guestBean;
}
