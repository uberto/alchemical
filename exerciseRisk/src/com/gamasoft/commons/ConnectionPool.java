package com.gamasoft.commons;

public class ConnectionPool {

    static ConnectionPool instance = null;

    private boolean open = false;

    public Connection borrowConnection() {
        if (!open)
            throw new RuntimeException("Connection Pool not open!");
        return new Connection();
    }

    public void open(String connStr){
        Utils.notBlank(connStr, "connStr");

        open = true;
    }

    public static ConnectionPool getInstance() {
        if (instance == null)
            instance = new ConnectionPool();
        return instance;
    }
}
