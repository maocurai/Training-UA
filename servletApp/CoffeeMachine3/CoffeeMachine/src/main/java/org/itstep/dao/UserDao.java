package org.itstep.dao;

import org.itstep.exceptions.NoSuchUserException;
import org.itstep.model.entity.Role;
import org.itstep.model.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.itstep.mysql.CrudDao;
import org.itstep.mysql.TimeAccountingDB;



public class UserDao implements CrudDao<User> {

    public User findByNameAndPassword(String name, String password) throws NoSuchUserException {
        String SELECT_USER = "SELECT * FROM `usr` WHERE username=? and password=?";
        try {
            PreparedStatement preparedStatement = TimeAccountingDB.prepareStatement(SELECT_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = TimeAccountingDB.getResultSet(preparedStatement);
            resultSet.next();
            return createUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoSuchUserException();
        }
    }

    public boolean isExists(String name, String password) {
        String SELECT_USER = "SELECT * FROM `usr` WHERE username=? and password=?";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = TimeAccountingDB.prepareStatement(SELECT_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = TimeAccountingDB.getResultSet(preparedStatement);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        String INSERT_USERS_SQL = "INSERT INTO `users`(`username`, `password`, `isActive`) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = TimeAccountingDB.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setBoolean(1, user.isActive());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        String GET_ALL_USERS_SQL = "SELECT * FROM usr";
        List<User> usersList = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = TimeAccountingDB.getResultSet(GET_ALL_USERS_SQL);
             while (rs.next()) {
                 usersList.add(createUser(rs));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(1));
        user.setActive(rs.getBoolean(2));
        user.setPassword(rs.getString(3));
        user.setRole(Role.valueOf(rs.getString(4)));
        user.setUsername(rs.getString(5));
        return user;
    }
}
