package com.gamasoft.hs.after;

import java.util.function.Function;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }

    public <T> T withConnection(Function<Connection, T> f) {
        Connection c = borrowConnection();
        T res = f.apply(c);
        returnConnection(c);
        return res;
    }

    private void returnConnection(Connection c) {
      //place connection to the pool
    }

    public boolean authUser(String clientId) {
        return true;
    }
}
