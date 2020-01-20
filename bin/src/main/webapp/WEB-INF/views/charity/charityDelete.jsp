<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 25.02.19
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Organization</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: DELETE ORGANIZATION </h1>

<h2>Czy na pewno chcesz usunąć tą organizację? </h2>
<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Nazwa</td>
                <td>Miasto</td>
                <td>Rodzaj</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${toRemove.id}</td>
                <td>${toRemove.charityName}</td>
                <td>${toRemove.city}</td>
                <td>${toRemove.charityActivityType.organizationActivity}</td>
            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/admin/${toRemove.id}/deleteOrg" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/admin/orgList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>
