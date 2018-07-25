package com.ex.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static SQLConnection connectionUtil = new SQLConnection();
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private SQLConnection() {

    }

    public static SQLConnection getConnectionUtil() {
        if (connectionUtil == null) {
            connectionUtil = new SQLConnection();
        }
        return connectionUtil;
    }

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost/project_one";
        String username="postgres";
        String password="";
        try {
            return DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
