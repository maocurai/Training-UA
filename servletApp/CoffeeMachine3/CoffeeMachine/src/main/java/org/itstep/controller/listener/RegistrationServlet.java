package org.itstep.controller.listener;

import org.itstep.dao.UserDao;
import org.itstep.model.entity.Role;
import org.itstep.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setActive(true);
        user.setPassword(request.getParameter("pass"));
        user.setRole(Role.USER);
        user.setUsername(request.getParameter("name"));

        String message = "User added!";
        try {
            userDao.addUser(user);
        } catch (SQLException | ClassNotFoundException throwables) {
            message = "User not added";
            request.setAttribute("message", message);
            throwables.printStackTrace();
        }
        System.out.println(message);
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}
