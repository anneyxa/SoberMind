<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 26.06.19
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project Form</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@ include file="../css/buttons.css"%>
    </style>
</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col-4">

            <h3>${empty project.id ? 'Add new project' : 'Edit following project'}</h3>

            <f:form action="#" method="post" modelAttribute="project">

                <div class="form-group">
                    <label>Name</label>
                    <c:if test="${empty project.id}">
                        <f:input path="name" cssClass="form-control"/>
                    </c:if>
                    <c:if test="${not empty project.id}">
                        <f:input path="name" disabled="true" cssClass="form-control"/>
                        <f:hidden path="name"/>
                    </c:if>
                    <f:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>Description</label>
                        <f:textarea path="description" cssClass="form-control"/><f:errors path="description" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>Site</label>
                        <f:input path="site" cssClass="form-control"/><f:errors path="site" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>Users</label>
                        <f:select cssClass="form-control" path="users" items="${users}" multiple="true" itemLabel="fullName" itemValue="id"/>
                    <f:errors path="users" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label>Active</label>
                        <f:checkbox cssClass="form-check-label" path="active"/><f:errors path="active" cssClass="error"/>
                </div>

                <div class="container-login100-form-btn py-2">
                    <input type="submit" class="login100-form-btn" value="${empty project.id ? 'Add' : 'Save'}"/>
                    <a href="<c:url value="/"/>"><button style="margin:auto" class="login100-form-btn">Cancel</button></a>
                </div>

            </f:form>
        </div>
        <div class="col"></div>
    </div>
</div>

    <jsp:include page="footer.jsp"/>

</body>
</html>
