package com.gamasoft.hs.step1;

public class Response {

    public final MarketData marketData;
    public final CalcResult result;

    public Response(MarketData marketData, CalcResult result) {

        this.marketData = marketData;
        this.result = result;
    }
}
