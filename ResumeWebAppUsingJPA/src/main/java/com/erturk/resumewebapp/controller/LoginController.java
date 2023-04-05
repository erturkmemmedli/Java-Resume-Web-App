package com.erturk.resumewebapp.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.erturk.dao.inter.UserDaoInter;
import com.erturk.entity.User;
import com.erturk.main.Context;
import com.erturk.resumewebapp.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    public UserDaoInter userDao = Context.instanceUserDao();
    private BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDao.findByEmail(email);

            if (user == null) {
                throw new IllegalArgumentException("User does not exist!");
            }

            BCrypt.Result result = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
            if (!result.verified) {
                throw new IllegalArgumentException("Password is incorrect!");
            }

            request.getSession().setAttribute("loggedInUser", user);
            response.sendRedirect("users");
        } catch (Exception ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }
}