<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 09.07.2017
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>
        <td>id</td>
        <td>name</td>
    <td>photo</td>
    <td>name photo</td>
    </th>
    <c:forEach items="${employeeListDepartments}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td><a href="/messageListEmployee/${employee.id}">${employee.name}</a></td>
            <td><img width="100" height="100" src="${pageContext.request.contextPath}/image/${employee.photo}"/></td>
            <td>${employee.photo}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
