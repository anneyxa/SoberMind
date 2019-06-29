<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit account</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@ include file="../css/sign-up.css"%>
    </style>
</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">
<jsp:include page="header.jsp"/>
<div>

    <c:if test="${not empty user}">
    </c:if>
    <c:if test="${empty user}">
    </c:if>

    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <div class="wrap-login100 shadow">
				        <span class="login100-form-title pb-3">
					        Edit your account
				        </span>
                    <f:form action="#" method="post" modelAttribute="user" cssClass="login100-form">
                        <div class="wrap-input100">
                            Login:
                            <f:input path="login" cssClass="input100"/> <f:errors path="login" cssClass="error"/>
                        </div>
                        <div class="wrap-input100">
                            Name:
                            <f:input path="name" cssClass="input100"/> <f:errors path="name" cssClass="error"/>
                        </div>
                        <div class="wrap-input100">
                            Surname:
                            <f:input path="surname" cssClass="input100"/> <f:errors path="surname" cssClass="error"/>
                        </div>
                        <div class="wrap-input100">
                            Password:
                            <f:password path="password" cssClass="input100"/> <f:errors path="password" cssClass="error"/>
                        </div>
                        <div class="container-login100-form-btn py-2">
                            <input type="submit" class="login100-form-btn" value="Login"/>
                            <button style="margin:auto" class="login100-form-btn" onclick="event.preventDefault(); window.location='/'">Cancel</button>
                        </div>
                    </f:form>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
