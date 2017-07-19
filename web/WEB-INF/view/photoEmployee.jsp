<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 15.07.2017
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>photoEmployee</th>
    </tr>
    <c:forEach items="${listEmployee}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td><img src="${pageContext.request.contextPath}/drow?id=${employee.id}"/></td>
            <%--<td><img src="data:image/png;base64,${employee.photoEmployee}"/> </td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
