package com.gamasoft.risk;

import com.gamasoft.markets.Portfolio;
import com.gamasoft.markets.Trade;

public class RiskEngine {
    private RiskConf riskConfig;

    public RiskEngine(RiskConf riskConfig) {
        this.riskConfig = riskConfig;
    }

    public double calculate(Portfolio portfolio) {
        double tot = 0;

        for (Trade t: portfolio.trades) {
            tot += riskConfig.singleRisk(portfolio, t);
        }

        return tot;
    }


}
