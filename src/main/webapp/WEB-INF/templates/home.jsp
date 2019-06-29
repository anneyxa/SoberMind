<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 21.06.19
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <div class="col-2">
            <h4>Last activity:</h4>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>
        <div class="col-10" style="padding-left: 5%; padding-right: 5%">
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
                        <td>${project.description}</td>
                        <td><a href="${project.site}">${project.site}</a></td>
                        <td><c:forEach var="user" items="${project.users}">
                            ${user.fullName}<br>
                        </c:forEach> </td>
                        <td>${project.created}</td>
                        <td>
                            <a href="edit-project?id=${project.id}"><img src="https://img.icons8.com/windows/32/000000/edit-property.png"></a>
                            <a href="delete-project?id=${project.id}"><img src="https://img.icons8.com/material-rounded/24/000000/delete-sign.png"></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p><a href="projects">See all projects</a>
                <a href="add-project"> Add a new project</a></p>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>