package com.gamasoft.commons;

import com.gamasoft.markets.StockExchange;
import com.gamasoft.markets.Trade;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Connection {
    private Random random = new Random();
    private String clientId;

    public StockExchange fetchExchangeData(String market) {
        return new StockExchange(market);
    }

    public List<Trade> fetchTrades() {
        Utils.notBlank(clientId, "clientId");

        if (clientId.contains("Gordon")){
            return Arrays.asList(
                    new Trade("BP.L", 12.3, 5),
                    new Trade("VOD.L", 23.4, 6),
                    new Trade("IBM.N", 65.4, 7),
                    new Trade("GM.N", 45.6, 10)
            );
        } else {
            return Arrays.asList(
                    new Trade("IBM.N", 65.4, 7),
                    new Trade("GOOGL.OQ", 234.5, 8),
                    new Trade("AAPL.OQ", 345.6, 9),
                    new Trade("AMZN.OQ", 456.7, 10),
                    new Trade("GM.N", 45.6, 11)
            );
        }
    }

    public void authUser(String clientId) {
        Utils.notBlank(clientId, "clientId");
        this.clientId = clientId;
    }

    public double fetchPrice(String stock, String exchangeName) {
        Utils.notBlank(stock, "stock");
        Utils.notBlank(exchangeName, "exchangeName");

        return random.nextDouble() * 10 + 50;
    }
}
