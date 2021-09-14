package org.itstep.mysql;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import java.sql.*;


public class TimeAccountingDB {

    private static Connection connection = null;

    @Context
    static
    ServletContext servletContext;

    static
    {
        try {
            String url = "jdbc:mysql://localhost:3306/time_accounting?useSSL=false";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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

    public static ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }
}
