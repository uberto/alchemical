package com.gamasoft.hs.after;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConnectionPool {
    public Connection borrowConnection() {
        return new Connection();
    }


    public void withConnection(Consumer<Connection> action) {
        Connection c = borrowConnection();
        action.accept(c);
        returnConnection(c);
    }

    private void returnConnection(Connection c) {
      //place connection to the pool
    }

    public boolean authUser(String clientId) {
        return true;
    }
}
