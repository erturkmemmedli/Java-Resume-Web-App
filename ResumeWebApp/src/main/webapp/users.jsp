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
    <title>Users</title>

    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="assets/css/logout.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script type="text/javascript" src="assets/js/users.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>
    <div class="navigation">
        <a class="button" href="logout" style="text-decoration: none">
            <img src="https://www.freeiconspng.com/thumbs/shutdown-icon/shutdown-icon-33.png">
            <div class="logging_out">LOGOUT</div>
        </a>
    </div>
    <div class="container">
        <div class="col-12">
            <div class="col-4">
                <form action="users" method="get">
                    <div class="form_group">
                        <label for="name">Name:</label>
                        <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
                    </div>
                    <div class="form_group">
                        <label for="surname">Surname:</label>
                        <input placeholder="Enter surname" class="form-control"
                               type="text" name="surname" value="" style="margin-bottom: 10px"/>
                    </div>
                    <input class="btn btn-primary" type="submit" value="Search" id="btnSearch"/>
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
                        <td><%=u.getCountry().getNationality()%></td>
                        <td style="width: 5px">
                            <input type="hidden" name="id" value="<%=u.getId()%>"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button class="btn btn-danger" type="submit" value="Delete"
                                    data-toggle="modal" data-target="#sureDelete"
                                    onclick="setIdForDelete(<%=u.getId()%>)">
                                <i class="fas fa-trash-alt"></i>
                            </button>
                        </td>
                        <td style="width: 5px">
                            <form action="userdetails" method="get">
                                <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                <input type="hidden" name="action" value="update"/>
                                <button class="btn btn-secondary" type="submit" value="Update">
                                    <i class="fas fa-pencil-alt"></i>
                                </button>
                            </form>
                        </td>
                        <td style="width: 5px">
                            <form action="userdetailsinfo" method="get">
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

    <div class="modal fade" id="sureDelete" tabindex="-1" role="dialog" aria-labelledby="sureDeleteLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="sureDeleteLabel">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <form action="userdetails" method="post">
                        <input type="hidden" name="id" value="" id="idForDelete"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-danger" value="Delete"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
