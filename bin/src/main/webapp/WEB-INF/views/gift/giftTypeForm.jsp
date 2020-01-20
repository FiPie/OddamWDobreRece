<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 27.02.19
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Gift Type Form</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>

<h1> ADMIN DASHBOARD: GIFT TYPE FORM </h1>

<section class="login-page">
    <h2>Dodaj Nowy Rodzaj Darowizny/Pomocy</h2>
    <form:form modelAttribute="giftTypeForm" action="/admin/giftTypeForm" method="post">
        <div class="form-group">
            <form:input path="giftType" placeholder="Podaj nowy typ darowizny" required="true"/><form:errors
                path="giftType"/>
        </div>
        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Dodaj Rodzaj Darowizny</button>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/giftTypeList" class="btn">Wstecz</a>
        </div>
    </form:form>
</section>


</body>
</html>