package com.gamasoft.hs.before;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }

    public boolean authUser(String clientId) {
        return true;
    }
}
