package com.gamasoft.hs.after;

import java.util.List;

public class Portfolio {
    public final String clientId;
    public final List<Integer> trades;

    public Portfolio(String clientId, List<Integer> trades) {

        this.clientId = clientId;
        this.trades = trades;
    }
}
