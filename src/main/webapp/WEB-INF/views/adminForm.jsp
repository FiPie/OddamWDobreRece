<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 20.02.19
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin Form</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>

<h1> ADMIN DASHBOARD: ADMIN FORM </h1>

<section class="login-page">
    <h2>Stwórz konto admina</h2>
    <form:form modelAttribute="adminForm" method="post">
        <div class="form-group">
            <form:input path="email" type="email" placeholder="Email" required="true"/><form:errors path="email"/>
        </div>
        <div class="form-group">
            <form:input path="firstName" placeholder="Podaj Imię" required="true"/><form:errors path="firstName"/>
        </div>
        <div class="form-group">
            <form:input path="lastName" placeholder="Podaj Nazwisko" required="true"/><form:errors path="lastName"/>
        </div>

        <div class="form-group">
            <form:password path="password" placeholder="Hasło" required="true"/><form:errors path="password"/>
        </div>

        <div class="form-group">
            <form:password path="confirmedPassword" placeholder="Powtórz hasło" required="true"/><form:errors path="confirmedPassword"/>
        </div>
        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Stwórz konto</button>
            <a href="/admin/adminList" class="btn">Wstecz</a>
        </div>
    </form:form>
</section>


</body>
</html>
