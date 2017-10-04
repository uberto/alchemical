package com.gamasoft.hs.after;

public class DataContextBuilder {

    private ConfigHelper configHelper; // <- injected
    private ConnectionPool connPool; // <- injected

    public DataContext createDataContext(String aMarket) {
        return new DataContext() {
            String market = aMarket;
            Context context = null;

            @Override
            public Portfolio applyTranform(Portfolio portfolio) {
                return connPool.withConnection(c -> getContext().applyTranform(c, portfolio));
            }

            @Override
            public double calculate(Portfolio portfolio) {
                return configHelper.getOptions(portfolio.clientId, getContext()).calculate(portfolio);
            }

            @Override
            public Context getContext() {
                if (context == null)
                    context = connPool.withConnection(c -> c.fetchContext(market));
                return context;
            }
        };
    }
}
