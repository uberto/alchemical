package com.gamasoft.hs.before;

public class Connection {
    public Context fetchContext(String market) {
        return new Context(market);
    }
}
