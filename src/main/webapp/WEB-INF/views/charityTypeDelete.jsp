<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 02.03.19
  Time: 07:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Type Delete</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: DELETE CHARITY TYPE </h1>

<h2>Czy na pewno chcesz usunąć tą formę działalności ZI? </h2>
<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Forma Działalności ZI</td>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${toRemove.id}</td>
                <td>${toRemove.organizationType}</td>

            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/admin/${toRemove.id}/deleteCharityType" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/admin/charityTypeList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>
