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
<body>

<div class="container">
  <form action="register" method="post">
    <div class="form_group">
      <label>Name: </label>
      <input type="text" class="form-control" name="name" placeholder="Enter your name"/>
    </div>
    <div class="form_group">
      <label>Surname: </label>
      <input type="text" class="form-control" name="surname" placeholder="Enter your surname"/>
    </div>
    <div>
      <label>Phone: </label>
      <input type="text" class="form-control" name="phone" placeholder="Enter your phone"/>
    </div>
    <div>
      <label>Email: </label>
      <input type="text" class="form-control" name="email" placeholder="Enter your email"/>
    </div>
    <div>
      <label>Password: </label>
      <input type="password" class="form-control" name="password" placeholder="Enter your password"
             style="margin-bottom: 10px"/>
    </div>
    <input type="submit" name="register" value="Register"/>
  </form>
</div>
</body>
</html>