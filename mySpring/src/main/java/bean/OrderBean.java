package bean;

import annotion.MyBean;

@MyBean
public class OrderBean {
    GuestBean guestBean;

    TradeBean tradeBean;
    public OrderBean(GuestBean guestBean, TradeBean tradeBean) {
        this.guestBean = guestBean;
        this.tradeBean = tradeBean;
    }
}
