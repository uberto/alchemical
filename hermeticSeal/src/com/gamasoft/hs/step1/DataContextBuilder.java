package com.gamasoft.hs.step1;

public class DataContextBuilder {

    public DataContext createDataContext(ConnectionPool aConnPool, String aMarket) {
        return new DataContext() {
            ConnectionPool connPool = aConnPool;
            String market = aMarket;
            @Override
            public Connection getConnection() {
                return connPool.borrowConnection();
            }

            @Override
            public Options getOptions() {
                return new Options();
            }

            @Override
            public Context getContext() {
                return new Context(market);
            }
        };
    }
}
