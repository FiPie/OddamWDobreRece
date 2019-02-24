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

<section class="steps">
    <h2>ADMINS:</h2>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Email</td>
                    <td>Imię</td>
                    <td>Nazwisko</td>
                </tr>
                </thead>
                <c:forEach var="admin" items="${sessionScope.adminList}">
                    <tbody>
                    <tr>
                        <th scope="row">${admin.id}</th>
                        <td scope="row">${admin.email}</td>
                        <td scope="row">${admin.firstName}</td>
                        <td scope="row">${admin.lastName}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/admin/${admin.id}/confirmDeleteAdmin"
                                   class="btn btn--small">Usuń ${admin.firstName}</a>

                                <a href="/admin/${admin.id}/editAdmin"
                                   class="btn btn--small">Edytuj ${admin.firstName}</a>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/admin/adminForm" class="btn btn--medium">Dodaj Nowego Admina</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
