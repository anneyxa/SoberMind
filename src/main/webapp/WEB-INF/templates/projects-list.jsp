<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 24.06.19
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Projects</title>
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
                    <th scope="col">Project name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Site</th>
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
                        <td>${project.created}</td>
                        <td>
                            <a href="edit-project?id=${project.id}"><img src="https://img.icons8.com/windows/32/000000/edit-property.png"></a>
                            <a href="delete-project?id=${project.id}"><img src="https://img.icons8.com/material-rounded/24/000000/delete-sign.png"></a>
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
