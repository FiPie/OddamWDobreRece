<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 19.02.19
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin List</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: ADMIN LIST </h1>
<table>
    <c:forEach var="admin" items="${sessionScope.adminList}">
        <tbody>
        <tr>
            <th scope="row">${admin.id}</th>
            <td scope="row">${admin.email}</td>
            <td scope="row">${admin.firstName}</td>
            <td scope="row">${admin.lastName}</td>
            <td scope="row">
                <div class="form-group form-group--buttons">
                    <%--<a href="/admin/delete" class="btn btn--small">Usuń ${admin.firstName}</a>--%>
                    <a href="/admin/${admin.id}/confirmDelete" class="btn btn--small">Usuń ${admin.firstName}</a>

                    <a href="/admin/edit" class="btn btn--small">Edytuj ${admin.firstName}</a>
                </div>
            </td>
        </tr>

        </tbody>
    </c:forEach>
</table>
<a href="/admin/adminForm" class="btn btn--medium">Dodaj Nowego Admina</a>
</body>
</html>
