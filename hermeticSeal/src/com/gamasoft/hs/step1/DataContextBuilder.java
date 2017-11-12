package com.gamasoft.hs.step1;


public class DataContextBuilder {

    public DataContext createDC(ConnectionPool aConnPool, String aMarket, String aClient) {

        return new DataContext() {

            ConnectionPool connPool = aConnPool;
            String market = aMarket;
            String client = aClient;

            @Override
            public Connection getConnection() {
                return connPool.borrowConnection();
            }

            @Override
            public ConfigManager getConfigManager() {
                return new ConfigManager(client + "_ " + market + ".yaml");
            }

            @Override
            public MarketData getMarketData() {
                return connPool.borrowConnection().fetchMarketData(market);
            }
        };
    }
}
