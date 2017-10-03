package com.gamasoft.hs.after;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }

    public boolean authUser(String clientId) {
        return true;
    }
}
