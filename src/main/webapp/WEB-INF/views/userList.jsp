<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 19.02.19
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User List</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: USER LIST </h1>
<table>
<c:forEach var="user" items="${sessionScope.userList}">
    <tbody>
    <tr>
        <th scope="row">${user.id}</th>
        <td scope="row">${user.email}</td>
        <td scope="row">${user.firstName}</td>
        <td scope="row">${user.lastName}</td>
    </tr>
    </tbody>
</c:forEach>
</table>
</body>
</html>
