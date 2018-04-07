package com.gamasoft;

public class Response {

    public final MarketData marketData;
    public final CalcResult result;

    public Response(MarketData marketData, CalcResult result) {

        this.marketData = marketData;
        this.result = result;
    }
}
