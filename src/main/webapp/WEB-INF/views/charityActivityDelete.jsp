<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 01.03.19
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Activity Delete</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: DELETE CHARITY ACTIVITY </h1>

<h2>Czy na pewno chcesz usunąć ten typ/grupę docelową niesienia pomocy przez ZI? </h2>
<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Komu pomagamy?</td>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${toRemove.id}</td>
                <td>${toRemove.organizationActivity}</td>

            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/admin/${toRemove.id}/deleteCharityActivity" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/admin/charityActivityList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>
