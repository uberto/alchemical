package com.gamasoft.hs.step1;

public class Connection {
    public Context fetchContext(String market) {
        return new Context(market);
    }
}
