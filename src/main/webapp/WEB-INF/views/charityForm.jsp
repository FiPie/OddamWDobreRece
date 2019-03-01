<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 25.02.19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Organization Form</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>

<h1> ADMIN DASHBOARD: ORGANIZATION FORM </h1>

<section class="login-page">
    <h2>Dodaj Nową Zaufaną Organizację</h2>
    <form:form modelAttribute="orgForm" action="/admin/organizationForm" method="post">
        <div class="form-group">
            <form:input path="charityName" placeholder="Podaj nazwę organizacji" required="true"/><form:errors
                path="charityName"/>
        </div>
        <div class="form-group">
            <form:input path="city" placeholder="Podaj miasto, w którym działa organizacja"
                        required="true"/><form:errors path="city"/>
        </div>
        <%--<div class="form-group">
            <form:input path="charityActivityType" placeholder="Podaj rodzaj pomocy niesionej przez organizację"
                        required="true"/><form:errors path="charityActivityType"/>
        </div class="form-group">--%>
        <div>
            <form:radiobuttons delimiter="<br/>" path="charityActivityType" items="${charityActivityList}" itemLabel="organizationActivity"
                               itemValue="id"/><form:errors path="charityActivityType"/>
        </div>
        <div>
            <form:radiobuttons delimiter="<br/>" path="charityStructureType" items="${charityTypeList}" itemLabel="organizationType"
                               itemValue="id"/><form:errors path="charityStructureType"/>
        </div>
        <div class="form-group">
            <form:checkboxes delimiter="<br/>" path="acceptedGiftTypes" multiple="true" items="${giftTypeList}"
                             itemLabel="giftType" itemValue="id"/><form:errors path="acceptedGiftTypes"/>
        </div>

        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Dodaj Organizację</button>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/admin/orgList" class="btn">Wstecz</a>
        </div>

    </form:form>
</section>


</body>
</html>
