package com.gamasoft.hs.step1;

public class ConnectionHelper {

    public Connection connect(String clientId, ConnectionPool connections) {

        connections.authUser(clientId);
        return connections.borrowConnection();
    }

}
