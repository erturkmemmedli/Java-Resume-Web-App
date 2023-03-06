package com.erturk.resumeapp.controller;

import dao.inter.UserDaoInter;
import entitiy.User;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        UserDaoInter userDao = Context.instanceUserDao();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String countryIdStr = request.getParameter("nationalityId");
        Integer countryId = null;

        if (countryIdStr != null && !countryIdStr.trim().isEmpty()) {
            countryId = Integer.parseInt(countryIdStr);
        }

        List<User> users = userDao.getAllByNameSurnameNationality(name, surname, countryId);

        request.setAttribute("users", users);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
