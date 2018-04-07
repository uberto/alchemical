package com.gamasoft;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }

    public boolean authUser(String clientId) {
        return true;
    }

    public static ConnectionPool getInstance() {
        return new ConnectionPool();
    }
}
