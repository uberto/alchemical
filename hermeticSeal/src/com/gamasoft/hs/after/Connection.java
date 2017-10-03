package com.gamasoft.hs.after;

public class Connection {
    public Context fetchContext(String market) {
        return new Context(market);
    }
}
