package com.gamasoft.hs.before;

public class Connection {
    public MarketData fetchMarketData(String market) {
        return new MarketData(market);
    }
}
