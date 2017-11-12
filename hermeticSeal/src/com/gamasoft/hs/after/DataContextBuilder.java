package com.gamasoft.hs.after;

import java.util.function.Consumer;

public class DataContextBuilder {

    private ConnectionPool connPool; // <- injected

    public DataContext createDataContext(String aMarket, String aClient) {
        return new DataContext() {

            String market = aMarket;
            String client = aClient;

            @Override
            public void withConnection(Consumer<Connection> action) {
                connPool.withConnection(action);
            }

            @Override
            public String getRisk() {
                ConfigManager configManager = new ConfigManager(client + "_ " + market + ".yaml");
                return configManager.get("risk");
            }

            @Override
            public MarketData getMarketData() {
                return connPool.borrowConnection().fetchMarketData(market);
            }


        };
    }
}
