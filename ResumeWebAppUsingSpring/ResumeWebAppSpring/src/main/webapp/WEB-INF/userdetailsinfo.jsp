<%@ page import="com.erturk.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 23.02.2023
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Details Info</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
<%--        <jsp:include page="header.jsp"/>--%>
        <%
            User user = (User) request.getAttribute("user");
        %>
        <div class="container">
            <input type="hidden" name="id" value="<%=user.getId()%>">
            <input type="hidden" name="action" value="update"/>
            <div class="form_group">
                <label>Name: </label>
                <input type="text" class="form-control" name="name" value="<%=user.getName()%>"/>
            </div>
            <div class="form_group">
                <label>Surname: </label>
                <input type="text" class="form-control" name="surname" value="<%=user.getSurname()%>"/>
            </div>
            <div class="form_group">
                <label>Address: </label>
                <input type="text" class="form-control" name="address" value="<%=user.getAddress()%>"/>
            </div>
            <div>
                <label>Phone: </label>
                <input type="text" class="form-control" name="phone" value="<%=user.getPhone()%>"/>
            </div>
            <div>
                <label>Email: </label>
                <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>"/>
            </div>
            <div>
                <label>Profile Description: </label>
                <input type="text" class="form-control" name="profile" value="<%=user.getProfileDescription()%>"/>
            </div>
            <div>
                <label>Birthday: </label>
                <input type="text" class="form-control" name="birthday" value="<%=user.getBirthday()%>"/>
            </div>
            <div>
                <label>Birthplace: </label>
                <input type="text" class="form-control" name="birthplace"
                       value="<%=user.getCountryId() != null ? user.getCountryByCountryId().getName() : "null"%>"/>
            </div>
            <div>
                <label>Nationality: </label>
                <input type="text" class="form-control" name="nationality"
                       value="<%=user.getCountryId() != null ? user.getCountryByCountryId().getNationality() : "null"%>"
                       style="margin-bottom: 10px"/>
            </div>
        </div>
    </body>
</html>
