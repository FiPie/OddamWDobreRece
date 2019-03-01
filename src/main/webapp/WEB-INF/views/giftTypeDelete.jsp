<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 28.02.19
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Gift Type</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: DELETE GIFT TYPE </h1>

<h2>Czy na pewno chcesz usunąć ten typ darowizn? </h2>
<section class="login-page">
    <div class="form-group">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Typ darowizny</td>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${toRemove.id}</td>
                <td>${toRemove.giftType}</td>

            </tr>
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/admin/${toRemove.id}/deleteGiftType" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/admin/giftTypeList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>

    </div>
</section>

</body>
</html>