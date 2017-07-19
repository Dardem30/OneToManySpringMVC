<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 16.07.2017
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form enctype="multipart/form-data" action="/saveImageEmployee" method="post">
    <input type="text" name="name">
    <input type="file" name="photoE">
    <select placeholder="EnterDate" name="department.id">
        <c:forEach items="${listDepartment}" var="department" varStatus="status">
            <option value="${department.id}">
                <c:out value="${department.name}"/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="save">
</form>
</body>
</html>
