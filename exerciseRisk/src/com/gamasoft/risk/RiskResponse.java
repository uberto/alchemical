package com.gamasoft.risk;

import com.gamasoft.markets.StockExchange;

public class RiskResponse {

    public final StockExchange stockExchange;
    public final CalcResult result;

    public RiskResponse(StockExchange stockExchange, CalcResult result) {

        this.stockExchange = stockExchange;
        this.result = result;
    }
}
