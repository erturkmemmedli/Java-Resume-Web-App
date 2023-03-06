<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Application</title>
</head>
<body>
<a href="users.jsp">Users page</a><br/>
<br/>
<a href="userdetails.jsp">Details page</a><br/>
<br/>
<h1><%= "Login!" %></h1>
<form action="login" method="post">
    Enter username: <input type="text" name="user"><br>
    Enter password: <input type="password" name="pass">
    <input type="submit" value="Log In">
</form><br>
</body>
</html>