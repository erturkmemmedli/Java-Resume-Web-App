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

@WebServlet(name = "UserDetailController", value = "/userdetail")
public class UserDetailController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            User user = userDao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);

            userDao.updateUser(user);
        } else if (action.equals("delete")) {
            userDao.removeUser(id);
        }

        response.sendRedirect("user");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("ID is not specified. Please specify ID.");
            }

            Integer userId = Integer.parseInt(userIdStr);

            User user = userDao.getById(userId);
            if (user == null) {
                throw new IllegalArgumentException("There is no user with this ID.");
            }

            request.setAttribute("user", user);
            request.getRequestDispatcher("userdetails.jsp").forward(request, response);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            response.sendRedirect("error?message=" + ex.getMessage());
        }
    }
}
