package com.erturk.resumeapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/*")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletResponse res = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            if (req.getSession().getAttribute("loggedInUser") == null &&
                    !req.getRequestURI().contains("index") &&
                    !req.getRequestURI().contains("login") &&
                    !req.getRequestURI().contains("register")) {
                res.sendRedirect("index");
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
