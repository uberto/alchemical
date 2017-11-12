package com.gamasoft.hs.step1;

import java.util.List;

public class Main {

    private DataContextBuilder newModule;


    public Response execute(String client, String market, List<Integer> trades, ConnectionPool conns){
        Portfolio pf = new Portfolio(client, trades);

        DataContext dc = newModule.createDC(conns, market, client);

        CalcResult r = runCalculations(pf, dc.getConnection(), dc.getConfigManager(), dc.getMarketData());

        return new Response(dc.getMarketData(), r);

    }


    private CalcResult runCalculations(Portfolio portfolio, Connection conn, ConfigManager configMan, MarketData marketData) {

        String riskConf = configMan.get("risk");
        RiskEngine risk = new RiskEngine(riskConf);

        //some very complex calculations
        portfolio.enrichWithMarketData(marketData, conn);

        //others very complex calculations
        double x = risk.calculate(portfolio);

        return CalcResult.success(x);

    }

    public static void main(String[] args){
        //... calling execute..
    }
}
