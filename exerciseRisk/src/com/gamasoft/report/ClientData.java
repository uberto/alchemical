package com.gamasoft.report;

import com.gamasoft.markets.Portfolio;

import java.util.ArrayList;
import java.util.List;

public class ClientData {
    private final String clientId;
    private final Portfolio portfolio;
    public RiskData riskData;


    public ClientData(String clientId, Portfolio portfolio) {
        this.clientId = clientId;
        this.portfolio = portfolio;

    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        lines.add(clientId);
        lines.add(riskData.riskResponse.stockExchange.getExchangeName());
        lines.add(riskData.riskResponse.stockExchange.getCurrency());
        lines.add("trades: " + portfolio.trades.size());
        return lines;
    }

}
