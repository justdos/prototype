package bean;

import annotion.MyBean;

@MyBean
public class TradeBean {
    private String tradeID;

    private OrderBean orderBean;

    private GuestBean guestBean;

    public TradeBean(String tradeID, OrderBean orderBean, GuestBean guestBean) {
        this.tradeID = tradeID;
        this.orderBean = orderBean;
        this.guestBean = guestBean;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }
}
