<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User details</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col">
            <h3>${user.login} - account details</h3>
            <hr>
            <ul>
                <li>Name: ${user.name}</li>
                <li>Surname: ${user.surname}</li>
            </ul>
            <%--<h5>Change login:</h5>--%>
            <%--<f:form action="/edit-account/${user.id}" method="post" modelAttribute="user">--%>
                <%--<f:input path="login" cssClass="form-control"/><f:errors path="login" cssClass="error"/>--%>
                <%--<f:hidden path="name"/>--%>
                <%--<f:hidden path="surname"/>--%>
                <%--<input type="submit" class="login100-form-btn" value="Save"/>--%>
            <%--</f:form>--%>
            <%--<h5>Change password:</h5>--%>
            <%--<f:form action="/edit-account/${user.id}" method="post" modelAttribute="user">--%>
                <%--<f:password path="password" cssClass="form-control"/><f:errors path="password" cssClass="error"/>--%>
                <%--<input type="submit" class="login100-form-btn" value="Save"/>--%>
            <%--</f:form>--%>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
