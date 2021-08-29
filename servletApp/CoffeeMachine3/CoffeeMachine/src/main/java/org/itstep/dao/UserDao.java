package org.itstep.dao;

import org.itstep.model.entity.Role;
import org.itstep.model.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.mysql.TimeAccountingDB;



public class UserDao {

    public void addUser(User user) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO `usr` (`id`, `active`, `password`, `role`, `username`) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = TimeAccountingDB.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setInt(1, 1);
        preparedStatement.setBoolean(2, user.isActive());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getRole());
        preparedStatement.setString(5, user.getUsername());
        preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() {
        String GET_ALL_USERS_SQL = "SELECT id, role, username FROM usr";
        List<User> usersList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = TimeAccountingDB.getResultSet(GET_ALL_USERS_SQL);

             while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setRole(Role.valueOf(rs.getString(2)));
                user.setUsername(rs.getString(3));
                usersList.add(user);
        }} catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
