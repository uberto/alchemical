package com.gamasoft.risk;

import com.gamasoft.commons.*;
import com.gamasoft.markets.Portfolio;
import com.gamasoft.markets.StockExchange;
import com.gamasoft.markets.Trade;

import java.util.List;
import java.util.Map;

public class RiskCalculator {
    private ConnectionHelper connHelper = new ConnectionHelper();
    private ConfigHelper configHelper;

    public RiskCalculator() {
        this.configHelper = ConfigHelper.readFromResources();
    }


    public RiskResponse calculateValueAtRisk(String client, String market, Portfolio pf){

        Connection conn = connHelper.connect(client, ConnectionPool.getInstance());

        StockExchange stockExchange = conn.fetchExchangeData(market);

        ConfigManager riskConf = configHelper.getRiskConfig(client, market);

        CalcResult res = runCalculations(pf, conn, riskConf, stockExchange);

        return new RiskResponse(stockExchange, res);

    }

    private CalcResult runCalculations(Portfolio portfolio, Connection conn, ConfigManager configMan, StockExchange md) {

        Map<String, Double> riskParams = configMan.get("risk");
        RiskConf riskConf = new RiskConf( riskParams.get("vol"), riskParams.get("bump"));
        RiskEngine risk = new RiskEngine(riskConf);

        //some very complex calculations
        portfolio.enrichWithMD(md, conn);

        //others very complex calculations
        double x = risk.calculate(portfolio);

        return CalcResult.success(x);
    }


    public Portfolio getPortfolio(String clientName) {
        List<Trade> trades = ConnectionPool.getInstance().borrowConnection().fetchTrades();

        return new Portfolio(clientName, trades);
    }


    public double calculatePresentValue(String clientName, String market) {
        List<Trade> trades = ConnectionPool.getInstance().borrowConnection().fetchTrades();

        Connection conn = connHelper.connect(clientName, ConnectionPool.getInstance());

        StockExchange stockExchange = conn.fetchExchangeData(market);

        Portfolio portfolio = new Portfolio(clientName, trades);

        portfolio.enrichWithMD(stockExchange, conn);

        RiskConf priceConf = new RiskConf(1, 0);
        RiskEngine risk = new RiskEngine(priceConf);

        return risk.calculate(portfolio);


    }
}
