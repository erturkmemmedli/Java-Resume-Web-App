<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 13.03.2023
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .login_background {
            background: url("https://iprinfo.fi/wp-content/uploads/sites/2/2021/10/nasa-Q1p7bh3SHj8-unsplash.jpg");
        }
        .login_fix {
            border: white;
            padding-top: 172px;
            font-style: italic;
            color: aliceblue;
            width: 500px;
            height: 500px;
        }
    </style>
</head>

<body class="login_background">
    <form action="login" method="post">
        <div class="col-4 container login_fix">
            <center>
                <h1>LOGIN</h1><br/>
            </center>
            <div class="form-group">
                <label>Email address</label>
                <input type="text" class="form-control" placeholder="Enter your email" name="username">
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Enter your password" name="password">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary" name="login">Login</button>
        </div>
    </form>
</body>
</html>