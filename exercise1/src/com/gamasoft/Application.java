package com.gamasoft;

import java.util.List;

public class Application {
    private ConnectionHelper connHelper = new ConnectionHelper();
    private ConfigHelper configHelper;
    private ConnectionPool connPool;

    public Application() {
        this.configHelper = new ConfigHelper("confFile.properties");
        this.connPool = ConnectionPool.getInstance();
    }


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

    public Response calculateTodayRisk(String clientName, String market) {
        List<Integer> trades = connPool.borrowConnection().fetchTrades();

        return execute(clientName, market, trades, connPool);
    }
}
