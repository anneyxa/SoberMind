<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
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

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <div class="container">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <div class="wrap-login100 shadow">
				        <span class="login100-form-title pb-3">
					        Log in
				        </span>
                    <f:form action="#" method="post" modelAttribute="registeredUser" cssClass="login100-form">
                        <div class="wrap-input100">
                            <f:input path="login" cssClass="input100" placeholder="Login"/> <f:errors path="login" cssClass="error"/>
                        </div>
                        <div class="wrap-input100">
                            <f:password path="password" cssClass="input100" placeholder="Password"/> <f:errors path="password" cssClass="error"/>
                        </div>
                        <div class="container-login100-form-btn py-2">
                            <input type="submit" class="login100-form-btn" value="Login"/>
                        </div>
                    </f:form>
                    <button style="margin:auto" class="login100-form-btn" onclick="window.location='/signup'">Sign up</button>

                </div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
