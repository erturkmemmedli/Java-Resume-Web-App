<%@ page import="entitiy.User" %>
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
        <title>Details</title>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("user");
        %>
        <div>
            <form action="userdetail" method="post">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <input type="hidden" name="action" value="update"/>
                <label>Name: </label>
                <input type="text" size=30 name="name" value="<%=user.getName()%>"/><br/>
                <br/>
                <label>Surname: </label>
                <input type="text" size=30 name="surname" value="<%=user.getSurname()%>"/><br/>
                <br/>
                <label>Address: </label>
                <input type="text" size=30 name="address" value="<%=user.getAddress()%>"/><br/>
                <br/>
                <label>Phone: </label>
                <input type="text" size=30 name="phone" value="<%=user.getPhone()%>"/><br/>
                <br/>
                <label>Email: </label>
                <input type="text" size=30 name="email" value="<%=user.getEmail()%>"/><br/>
                <br/>
                <label>Birthday: </label>
                <input type="text" size=30 name="birthday" value="<%=user.getBirthday()%>"/><br/>
                <br/>
                <label>Birthplace: </label>
                <input type="text" size=30 name="email" value="<%=user.getCountry().getName()%>"/><br/>
                <br/>
                <label>Nationality: </label>
                <input type="text" size=30 name="birthday" value="<%=user.getCountry().getNationality()%>"/><br/>
                <br/>
                <input type="submit" name="save" value="Save"/>
            </form>
        </div>
    </body>
</html>
