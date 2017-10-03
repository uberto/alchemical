package com.gamasoft.hs.step1;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }

    public boolean authUser(String clientId) {
        return true;
    }
}
