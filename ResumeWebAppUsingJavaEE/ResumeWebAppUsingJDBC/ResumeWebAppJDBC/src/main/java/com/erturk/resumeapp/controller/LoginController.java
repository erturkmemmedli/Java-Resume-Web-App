package com.erturk.resumeapp.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.erturk.resumeapp.util.ControllerUtil;
import dao.inter.UserDaoInter;
import entity.User;
import main.Context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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