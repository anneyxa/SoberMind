<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ania
  Date: 29.06.19
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project details</title>
</head>
<body>
<c:forEach items="${project.tasks}" var="task" varStatus="loop">
    ${task.topic}
</c:forEach>
</body>
</html>
