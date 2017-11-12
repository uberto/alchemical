package com.gamasoft.hs.after;

import java.util.function.Consumer;

public interface DataContext {
    void withConnection(Consumer<Connection> action);
    String getRisk();
    MarketData getMarketData();
}
