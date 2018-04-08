package com.gamasoft.commons;

public class ConnectionHelper {

    public Connection connect(String clientId, ConnectionPool connections) {

        Connection connection = connections.borrowConnection();
        connection.authUser(clientId);
        return connection;
    }

}
