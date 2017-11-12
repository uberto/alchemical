package com.gamasoft.hs.step1;

import java.util.List;

public class Portfolio {
    private String clientId;
    private List<Integer> trades;

    public Portfolio(String clientId, List<Integer> trades) {

        this.clientId = clientId;
        this.trades = trades;
    }

    public void enrichWithMarketData(MarketData marketData, Connection conn) {
//        conn.fetchClientData(clientId);
//        conn.fetchTradesMarketData(marketData trades);

    }
}
