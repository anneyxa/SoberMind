<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered users</title>
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
                    <th scope="col">Login</th>
                    <th scope="col">Name and surname</th>
                    <th scope="col">Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${user.login}</td>
                        <td>${user.fullName}</td>
                        <td>
                            <c:if test="${loggedUser == user}">
                                <a href="edit-account/${user.id}"><img src="https://img.icons8.com/windows/32/000000/edit-property.png"></a>
                            </c:if>
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
