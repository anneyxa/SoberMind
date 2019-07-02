<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tasks</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">

<jsp:include page="header.jsp"/>

<div class="container-fluid text-center">
    <div class="row">
        <div class="col-sm-10">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Created</th>
                    <th scope="col">Topic</th>
                    <th scope="col">User assigned</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tasks}" var="task" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${task.created}</td>
                        <td>${task.topic}</td>
                        <td>${task.user.fullName}</td>
                        <td>
                            <a href="delete-task/${task.id}"><img src="https://img.icons8.com/material-rounded/24/000000/delete-sign.png"></a>
                            <a href="see-task/${task.id}">&#128065;</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
