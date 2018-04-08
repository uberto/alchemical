package com.gamasoft.markets;

import com.gamasoft.commons.Connection;
import com.gamasoft.commons.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Portfolio {
    public final String clientId;
    public final List<Trade> trades;
    public final Map<String, Double> prices = new HashMap<>();

    public Portfolio(String clientId, List<Trade> trades) {
        Utils.notBlank(clientId, "clientId");

        this.clientId = clientId;
        this.trades = trades;
    }

    public void enrichWithMD(StockExchange stockExchange, Connection conn) {

        String ccy = stockExchange.getCurrency();
        prices.put(ccy, conn.fetchPrice(ccy, stockExchange.getExchangeName()));
        for (Trade trade : trades) {
            double price = conn.fetchPrice(trade.stock, stockExchange.getExchangeName());
            prices.put(trade.stock, price);
        }
    }
}
