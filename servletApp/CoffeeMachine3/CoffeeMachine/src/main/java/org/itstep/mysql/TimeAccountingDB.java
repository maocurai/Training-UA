package org.itstep.mysql;

import java.sql.*;

public class TimeAccountingDB {

    private static Connection connection = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/springapp_bd?useSSL=false";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }

    public static PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public static ResultSet getResultSet(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }
}
