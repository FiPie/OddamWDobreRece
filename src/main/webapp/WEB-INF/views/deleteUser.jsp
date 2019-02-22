<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 22.02.19
  Time: 08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: DELETE USER </h1>

<h2>Czy na pewno chcesz usunąć usera? </h2>
<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Imię</td>
                <td>Naziwsko</td>
                <td>Email</td>
                <td>Aktywny</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${toRemove.id}</td>
                <td>${toRemove.firstName}</td>
                <td>${toRemove.lastName}</td>
                <td>${toRemove.email}</td>
                <td>${toRemove.enabled}</td>
            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/admin/${toRemove.id}/deleteUser" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/admin/userList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>
