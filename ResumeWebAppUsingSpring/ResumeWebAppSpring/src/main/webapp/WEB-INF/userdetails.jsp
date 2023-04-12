<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>User Details</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%--<jsp:include page="header.jsp"/>--%>
<div class="container">
    <form:form action="userupdate" method="POST" modelAttribute="user">
        <form:input type="hidden" path="id" value="${user.id}"/>
        <input type="hidden" name="action" value="update"/>
        <div class="form_group">
            <label>Name: </label>
            <form:input type="text" class="form-control" path="name" value="${user.name}"/>
        </div>
        <div class="form_group">
            <label>Surname: </label>
            <form:input type="text" class="form-control" path="surname" value="${user.surname}"/>
        </div>
        <div>
            <label>Phone: </label>
            <form:input type="text" class="form-control" path="phone" value="${user.phone}"/>
        </div>
        <div>
            <label>Email: </label>
            <form:input type="text" class="form-control" path="email" value="${user.email}"/>
        </div>
        <div>
            <label>Profile Description: </label>
            <form:input type="text" class="form-control" path="profileDescription" value="${user.profileDescription}"/>
        </div>
        <form:button type="submit" name="save">
            Save
        </form:button>
    </form:form>
</div>
</body>
</html>