package com.gamasoft.hs.after;

public class DataContextBuilder {

    private ConfigHelper configHelper;

    public DataContext createDataContext(ConnectionPool aConnPool, String aMarket) {
        return new DataContext() {
            ConnectionPool connPool = aConnPool;
            String market = aMarket;

            @Override
            public Connection getConnection() {
                return connPool.borrowConnection();
            }

            @Override
            public double calculate(Portfolio portfolio) {
                return configHelper.getOptions(portfolio.clientId, getContext()).calculate(portfolio);
            }

            @Override
            public Context getContext() {
                return connPool.borrowConnection().fetchContext(market);
            }
        };
    }
}
