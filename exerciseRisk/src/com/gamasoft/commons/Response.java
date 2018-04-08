package com.gamasoft.commons;

import com.gamasoft.risk.CalcResult;
import com.gamasoft.markets.StockExchange;

public class Response {

    public final StockExchange stockExchange;
    public final CalcResult result;

    public Response(StockExchange stockExchange, CalcResult result) {

        this.stockExchange = stockExchange;
        this.result = result;
    }
}
