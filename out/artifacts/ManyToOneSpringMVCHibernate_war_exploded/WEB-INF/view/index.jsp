<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sprng" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 07.07.2017
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>
<form:form method="get" modelAttribute="department" action="/saveDepartment">
    <div class="form-group">
        <form:input path="name"/>
    <form:button>ok</form:button>
    </div>
</form:form>
</td>
<td>
<spring:form modelAttribute="employee" method="post" action="/saveImageEmployee">
    <input name="name" type="text">
    <input name="photo" type="text">
    <spring:input path="photoEmployee" type="file" name="photoE"/>
    <select placeholder="EnterDate" name="department.id">
        <c:forEach items="${listDepartment}" var="department" varStatus="status">
            <option value="${department.id}">
                <c:out value="${department.name}"/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="img">
</spring:form>
</td>
        <td>
            <form method="post" enctype="multipart/form-data" action="/addImage">
                <input type="text" name="name"/>
                <select placeholder="EnterDate" name="department.id">
                    <c:forEach items="${listDepartment}" var="department" varStatus="status">
                        <option value="${department.id}">
                            <c:out value="${department.name}"/>
                        </option>
                    </c:forEach>
                </select>
                <input type="file" name="file">
                <input type="submit" value="ok">
            </form>
        </td>
        <td>
            <form method="post" enctype="multipart/form-data" action="/saveImageEmployee">
                <input type="text" name="name"/>
                <select placeholder="EnterDate" name="department.id">
                    <c:forEach items="${listDepartment}" var="department" varStatus="status">
                        <option value="${department.id}">
                            <c:out value="${department.name}"/>
                        </option>
                    </c:forEach>
                </select>
                <input type="file" name="photoEmployee">
                <input type="submit" value="ok">
            </form>
        </td>
</tr>
</thead>
</table>
<table>
    <th>
        <tr>id</tr>
        <tr>name</tr>
    </th>
    <c:forEach items="${listDepartment}" var="department">
        <tr>
            <td>${department.id}</td>
            <td><a href="/employeeListDepartment/${department.id}">${department.name}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
