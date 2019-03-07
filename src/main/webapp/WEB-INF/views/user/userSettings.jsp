<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 24.02.19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Settings</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menu.jsp"/>
</header>

<h2> ${LoggedUser.firstName} SETTINGS </h2>

<section class="steps">
    <div class="steps--container">
        <div class="steps--item">
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
                    <td>${LoggedUser.id}</td>
                    <td>${LoggedUser.firstName}</td>
                    <td>${LoggedUser.lastName}</td>
                    <td>${LoggedUser.email}</td>
                    <td>${LoggedUser.enabled}</td>
                </tr>
                </tbody>
            </table>
            <div class="steps--item">
                <a href="/user/changePassword" class="btn btn--large">Zmień Hasło</a>
            </div>
            <div class="steps--item">
                <a href="/user/editUser " class="btn btn--large">Edytuj Swój Profil</a>
            </div>
            <div class="steps--item">
                <a href="/user/confirmDeleteUserAccount" class="btn btn--large">Usuń Swoje Konto</a>
            </div>
            <div class="steps--item">
                <a href="/user/dashboard" class="btn btn--large" style="margin: 10px">Wstecz</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>
