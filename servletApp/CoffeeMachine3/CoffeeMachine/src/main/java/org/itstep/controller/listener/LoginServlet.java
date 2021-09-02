package org.itstep.controller.listener;

import org.itstep.dao.UserDao;
import org.itstep.exceptions.NoSuchUserException;
import org.itstep.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet  {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        try {
            user = userDao.findByNameAndPassword(request.getParameter("name"), request.getParameter("pass"));
            HttpSession session = request.getSession();
            session.setAttribute("loggedUserId", user.getId());
            session.setAttribute("loggedUsername", user.getUsername());
            session.setAttribute("loggedUserRole", user.getRole());
            session.setAttribute("isAdmin", user.isAdmin());
            session.setAttribute("loggedUserIsActive", user.isActive());
            response.sendRedirect(request.getContextPath() + "/");
        } catch (NoSuchUserException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
