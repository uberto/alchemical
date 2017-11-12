package com.gamasoft.hs.before;

import java.util.List;

public class Main {

    private ConnectionHelper connHelper;
    private ConfigHelper configHelper;

    public Response execute(String client, String market, List<Integer> trades, ConnectionPool conns){

        Connection conn = connHelper.connect(client, conns);

        MarketData marketData = conn.fetchMarketData(market);

        Portfolio pf = new Portfolio(client, trades);

        ConfigManager riskConf = configHelper.getRiskConfig(client, market);

        CalcResult res = runCalculations(pf, conn, riskConf, marketData);

        return new Response(marketData, res);

    }

    private CalcResult runCalculations(Portfolio portfolio, Connection conn, ConfigManager configMan, MarketData md) {

        String riskConf = configMan.get("risk");
        RiskEngine risk = new RiskEngine(riskConf);

        //some very complex calculations
        portfolio.enrichWithMD(md, conn);

        //others very complex calculations
        double x = risk.calculate(portfolio);

        return CalcResult.success(x);
    }

    public static void main(String[] args){
        //... calling execute..
    }
}

