package com.gamasoft.risk;

import com.gamasoft.markets.Portfolio;
import com.gamasoft.markets.Trade;

public class RiskConf {
    private final double vol;
    private final double bump;

    public RiskConf(double vol, double bump) {

        this.vol = vol;
        this.bump = bump;
    }

    public double singleRisk(Portfolio portfolio, Trade t) {
        double p = portfolio.prices.get(t.stock);
        double pv = (vol * p * t.qty) / t.price;


        if (bump == 0)
            return p;
        else {
            double r1 = bump * pv;
            double r2 = (1 - bump) * pv;
            return r1/r2;
        }

    }
}
