package com.gamasoft.hs.after;


public class Connection {
    public MarketData fetchMarketData(String market) {
        return new MarketData(market);
    }

}
