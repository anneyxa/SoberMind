<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 21.06.19
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pl.annurb.model.ActivityType" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <h4>Last activity:</h4>
            <ul class="list-group list-group-flush">
                <c:forEach items="${activities}" var="activity">
                    <li class="list-group-item">${activity.message} <br>
                        <c:if test="${activity.activityType != ActivityType.DELETE_PROJECT}">
                            <a href="${activity.site}"> Details &#8629; </a>
                        </c:if>
                    </li>
                </c:forEach>

            </ul>
        </div>
        <div class="col-9" style="padding-left: 5%; padding-right: 5%">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong>Hey, you!</strong> You should do some projects!
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Project name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Site</th>
                    <th scope="col">Users</th>
                    <th scope="col">Created/Updated</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projects}" var="project" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${project.name}</td>
                        <td><details>
                            <summary>Description</summary>
                            ${project.description}
                        </details></td>
                        <td><a href="${project.site}">${project.site}</a></td>
                        <td><c:forEach var="user" items="${project.users}">
                            ${user.fullName}<br>
                        </c:forEach> </td>
                        <td>${project.created}</td>
                        <td>
                            <a href="edit-project?id=${project.id}"><img src="https://img.icons8.com/windows/32/000000/edit-property.png"></a>
                            <c:if test="${empty project.tasks}">
                                <a href="delete-project?id=${project.id}"><img src="https://img.icons8.com/material-rounded/24/000000/delete-sign.png"></a>
                            </c:if>

                            <a href="/see-project/${project.id}">&#128065;</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p><a href="projects">See all projects</a><br>
                <a href="add-project"> Add a new project</a><br>
                <a href="users"> See all users</a><br>
                <a href="add-task">Add a new task</a><br>
                <a href="tasks">See all tasks</a><br>
            </p>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>