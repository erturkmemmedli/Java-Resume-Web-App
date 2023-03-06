<%@ page import="entitiy.User" %>
<%@ page import="dao.inter.UserDaoInter" %>
<%@ page import="main.Context" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Erturk Memmedli
  Date: 21.02.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="assets/css/users.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Users</title>
    </head>
    <body>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
        %>
        <div class="container">
            <div class="col-12">
                <div class="col-4">
                    <form action="user" method="get">
                        <div class="form_group">
                            <label for="name">Name:</label>
                            <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
                        </div>
                        <div class="form_group">
                            <label for="surname">Surname:</label>
                            <input placeholder="Enter surname" class="form-control" type="text" name="surname" value="" style="margin-bottom: 10px"/>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Search"/>
                    </form>
                </div>
                <div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Nationality</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (User u: users) {
                        %>
                        <tr>
                            <td><%=u.getName()%></td>
                            <td><%=u.getSurname()%></td>
                            <td><%=u.getCountry().getNationality()==null ? "N/A" : u.getCountry().getNationality()%></td>
                            <td style="width: 5px">
                                <form action="userdetail" method="post">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="delete"/>
                                    <button class="btn btn-danger" type="submit" value="Delete">
                                        <i class="fas fa-trash-alt"></i>
                                    </button>
                                </form>
                            </td>
                            <td style="width: 5px">
                                <form action="userdetail" method="get">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="update"/>
                                    <button class="btn btn-secondary" type="submit" value="Update">
                                        <i class="fas fa-pencil-alt"></i>
                                    </button>
                                </form>
                            </td>
                            <td style="width: 5px">
                                <form action="userdetail" method="get">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="info"/>
                                    <button class="btn btn-info" type="submit" value="Info">
                                        <i class="fas fa-info-circle"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
