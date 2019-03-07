<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 18.02.19
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AdminDashboard</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>

<h2> ADMIN DASHBOARD </h2>


<div class="steps--container">
    <div class="steps--item">
        <table class="table table-bordered table-striped">


            <tr>
                <td>Liczba Zarejestrowanych Użytkowników:</td>
                <td>${userNumber}</td>
            </tr>
            <tr>
                <td>Liczba Zarejestrowanych Adminów:</td>
                <td>${adminNumber}</td>
            </tr>
            <tr>
                <td>Liczba Zarejestrowanych Zaufanych Instytucji (ZI):</td>
                <td>${orgNumber}</td>
            </tr>
            <tr>
                <td>Ilość Rodzajów Grup Docelowych Pomocy prowadzonej przez ZI:</td>
                <td>${orgActivityNumber}</td>
            </tr>
            <tr>
                <td>Liczba Różnych Form Działalności ZI:</td>
                <td>${orgTypeNumber}</td>
            </tr>

        </table>
    </div>
</div>

</body>
</html>
