<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 04.04.2023
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registration</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<style>
  .error {color: red;}
</style>
<body>
<div class="container">
  <form:form action="register" method="POST" modelAttribute="user">
    <div class="form_group">
      <label>Name: </label>
      <form:input type="text" class="form-control" path="name" placeholder="Enter your name"/>
      <form:errors path="name" cssClass="error"/>
    </div>
    <div class="form_group">
      <label>Surname: </label>
      <form:input type="text" class="form-control" path="surname" placeholder="Enter your surname"/>
      <form:errors path="name" cssClass="surname"/>
    </div>
    <div>
      <label>Phone: </label>
      <form:input type="text" class="form-control" path="phone" placeholder="Enter your phone"/>
      <form:errors path="phone" cssClass="error"/>
    </div>
    <div>
      <label>Email: </label>
      <form:input type="text" class="form-control" path="email" placeholder="Enter your email"/>
      <form:errors path="email" cssClass="error"/>
    </div>
    <div>
      <label>Password: </label>
      <form:input type="password" class="form-control" path="password" placeholder="Enter your password"
                  style="margin-bottom: 10px"/>
      <form:errors path="password" cssClass="error"/>
    </div>
    <form:button class="btn btn-primary" type="submit" id="btnSearch">
      Register
    </form:button>
  </form:form>
</div>
</body>
</html>