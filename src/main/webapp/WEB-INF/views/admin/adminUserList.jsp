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
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: USER LIST </h1>

<section class="steps">
    <h2>USERS:</h2>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Email</td>
                    <td>Imię</td>
                    <td>Nazwisko</td>
                    <td>Usunięcie</td>
                    <td>Edycja</td>
                </tr>
                </thead>
                <c:forEach var="user" items="${sessionScope.userList}">
                    <tbody>
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td scope="row">${user.email}</td>
                        <td scope="row">${user.firstName}</td>
                        <td scope="row">${user.lastName}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/admin/${user.id}/confirmDeleteUser" class="btn btn--small">Usuń ${user.firstName}</a>
                            </div>
                        </td>
                        <td>
                            <div>
                                <a href="/admin/${user.id}/editUser" class="btn btn--small">Edytuj ${user.firstName}</a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/admin/dashboard" class="btn btn--large">Wstecz</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
