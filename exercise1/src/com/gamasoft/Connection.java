package com.gamasoft;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    public MarketData fetchMarketData(String market) {
        return new MarketData(market);
    }

    public List<Integer> fetchTrades() {
        return new ArrayList<>();
    }
}
