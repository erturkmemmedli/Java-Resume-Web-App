package com.erturk.resumeapp.controller;

import dao.inter.CountryDaoInter;
import dao.inter.UserDaoInter;
import entity.User;
import main.Context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();
    private CountryDaoInter countryDao = Context.instanceCountryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        userDao.addUser(user);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
