<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 10.07.2017
  Time: 11:24
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
        <tr>id</tr>
        <tr>name</tr>
    </th>
<c:forEach items="${messageListEmployee}" var="message">
   <tr>
       <td>${message.id}</td>
       <td>${message.value}</td>
   </tr>
    </c:forEach>
</table>
</body>
</html>
