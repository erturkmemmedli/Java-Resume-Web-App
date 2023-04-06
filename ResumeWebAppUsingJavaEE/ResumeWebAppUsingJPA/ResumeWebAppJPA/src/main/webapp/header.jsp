<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 27.03.2023
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) session.getAttribute("loggedInUser");
%>
<%= "Welcome " + user.getName() + "!!!"%>