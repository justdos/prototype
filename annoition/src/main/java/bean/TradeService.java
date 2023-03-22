package bean;

import myAnnoition.BizDao;

import java.util.Collection;

public interface TradeService {
    @BizDao(print = false)
    Collection<String> getTradeIDs(String companyID);
}
