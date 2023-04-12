<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 11.04.2023
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Admin Login</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="login_background">

<form action="logout" method="POST">
  <div class="col-4 container login_fix_">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" class="btn btn-primary">Logout</button>
  </div>
</form>

</body>
</html>