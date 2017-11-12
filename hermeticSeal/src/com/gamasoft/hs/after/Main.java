package com.gamasoft.hs.after;

import java.util.List;

public class Main {

    private DataContextBuilder newModule;

    public Response execute(String client, String market, List<Integer> trades){
        Portfolio pf = new Portfolio(client, trades);

        DataContext dc = newModule.createDataContext(market, client);

        CalcResult r = runCalculations(pf, dc);

        return new Response(dc.getMarketData(), r);

    }

    private CalcResult runCalculations(Portfolio portfolio, DataContext dc) {
        RiskEngine risk = new RiskEngine(dc.getRisk());

        //some very complex calculations
        dc.withConnection(c -> portfolio.enrichWithMD(dc.getMarketData(), c));

        //others very complex calculations
        double x = risk.calculate(portfolio);

        return CalcResult.success(x);
    }

    public static void main(String[] args){
        //... calling execute..
    }
}
