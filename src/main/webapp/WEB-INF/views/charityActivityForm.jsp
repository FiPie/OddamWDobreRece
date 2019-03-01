<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 01.03.19
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Activity Form</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>

<h1> ADMIN DASHBOARD: CHARITY ACTIVITY TYPE FORM </h1>

<section class="login-page">
    <h2>Dodaj Nowy Rodzaj Aktywności Charytatywnej/Grupy Pomocy</h2>
    <form:form modelAttribute="charityActivityForm" action="/admin/charityActivityForm" method="post">
        <div class="form-group">
            <form:input path="organizationActivity" placeholder="Podaj nową grupę pomocy" required="true"/><form:errors
                path="organizationActivity"/>
        </div>
        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Dodaj Typ Aktywności</button>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/charityActivityList" class="btn">Wstecz</a>
        </div>
    </form:form>
</section>


</body>
</html>