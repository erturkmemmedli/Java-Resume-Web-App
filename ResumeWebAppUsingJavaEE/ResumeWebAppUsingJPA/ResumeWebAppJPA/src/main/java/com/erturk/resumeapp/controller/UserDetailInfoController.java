package com.erturk.resumeapp.controller;

import com.erturk.resumeapp.util.ControllerUtil;
import dao.inter.UserDaoInter;
import entity.User;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDetailInfoController", value = "/userdetailsinfo")
public class UserDetailInfoController extends HttpServlet {
    private UserDaoInter userDao = Context.instanceUserDao();

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
            request.getRequestDispatcher("userdetailsinfo.jsp").forward(request, response);
        } catch (IllegalArgumentException ex) {
            ControllerUtil.errorPage(response, ex);
        }
    }
}
