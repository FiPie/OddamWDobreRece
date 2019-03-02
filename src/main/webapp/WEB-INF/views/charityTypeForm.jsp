<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 02.03.19
  Time: 07:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Type Form</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menuAdmin.jsp"/>
</header>

<h1> ADMIN DASHBOARD: CHARITY TYPE FORM </h1>

<section class="login-page">
    <h2>Dodaj Nową Formę Działalności Organizacji Charytatywnej</h2>
    <form:form modelAttribute="charityTypeForm" action="/admin/charityTypeForm" method="post">
        <div class="form-group">
            <form:input path="organizationType" placeholder="Forma działalności" required="true"/><form:errors
                path="organizationType"/>
        </div>
        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Dodaj Formę Działalności</button>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/charityTypeList" class="btn">Wstecz</a>
        </div>
    </form:form>
</section>


</body>
</html>