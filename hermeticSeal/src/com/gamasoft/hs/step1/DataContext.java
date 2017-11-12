package com.gamasoft.hs.step1;

public interface DataContext {

    Connection getConnection();
    ConfigManager getConfigManager();
    MarketData getMarketData();

}
