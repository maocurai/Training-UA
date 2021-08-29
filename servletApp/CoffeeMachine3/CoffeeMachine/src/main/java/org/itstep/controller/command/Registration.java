package org.itstep.controller.command;

import org.itstep.dao.UserDao;
import org.itstep.model.entity.Role;
import org.itstep.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Registration implements Command {

    private UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest request) {
        return "";
    }
}
