<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 24.02.19
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete User Account</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menu.jsp"/>
</header>

<h2> CZY NA PEWNO CHCESZ USUNĄĆ KONTO ${LoggedUser.email} ? </h2>

<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Imię</td>
                <td>Nazwisko</td>
                <td>Email</td>
                <td>Aktywny</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${LoggedUser.id}</td>
                <td>${LoggedUser.firstName}</td>
                <td>${LoggedUser.lastName}</td>
                <td>${LoggedUser.email}</td>
                <td>${LoggedUser.enabled}</td>
            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/user/deleteUser" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/user/settings" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>
