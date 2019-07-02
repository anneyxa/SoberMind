<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task form</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body style="background-image: url('https://images.pexels.com/photos/1061623/pexels-photo-1061623.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260'); background-repeat: no-repeat; background-size: cover; background-position: center">

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col-4">

            <h3>${empty task.id ? 'Add new task' : 'Edit following task'}</h3>
                <f:form action="#" method="post" modelAttribute="task">

                    <div class="form-group">
                        <label>Topic</label>
                        <f:input path="topic" cssClass="form-control"/><f:errors path="topic" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <f:textarea path="description" cssClass="form-control"/><f:errors path="description" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Project</label>
                        <f:select path="project.id" items="${projects}" itemLabel="name" itemValue="id" cssClass="form-control"/><f:errors path="project" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Status</label>
                        <f:select path="status.id" items="${statuses}" itemLabel="name" itemValue="id" cssClass="form-control"/><f:errors path="status" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Priority</label>
                        <f:select path="priority.id" items="${priorities}" itemLabel="name" itemValue="id" cssClass="form-control"/><f:errors path="priority" cssClass="error"/>
                    </div>
                    <%--<div class="form-group hidden-sm-3" id="toDo">--%>
                        <%--<label>User</label>--%>
                        <%--<f:select path="user" items="${task.project.users}" itemLabel="name" itemValue="id" cssClass="form-control"/><f:errors path="priority" cssClass="error"/>--%>
                    <%--</div>--%>
                    <div class="container-login100-form-btn py-2">
                        <input type="submit" class="login100-form-btn" value="${empty task.id ? 'Add' : 'Save'}"/>
                        <button style="margin:auto" class="login100-form-btn" onclick="event.preventDefault(); window.location='/'">Cancel</button>
                    </div>
                </f:form>
        </div>
        <div class="col"></div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
