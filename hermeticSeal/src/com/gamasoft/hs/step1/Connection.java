package com.gamasoft.hs.step1;


public class Connection {
    public MarketData fetchMarketData(String market) {
        return new MarketData(market);
    }
}
