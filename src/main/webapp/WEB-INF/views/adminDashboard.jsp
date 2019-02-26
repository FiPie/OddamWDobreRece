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
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>

<h2> ADMIN DASHBOARD </h2>


<div class="steps--container">
    <div class="steps--item">
        <table class="table table-bordered table-striped">


            <tr>
                <td>Ilość Zarejestrowanych Użytkowników:</td>
                <td>${userNumber}</td>
            </tr>
            <tr>
                <td>Ilość Zarejestrowanych Adminów:</td>
                <td>${adminNumber}</td>
            </tr>
            <tr>
                <td>Ilość Zarejestrowanych Organizacji:</td>
                <td>${orgNumber}</td>
            </tr>

        </table>
    </div>
</div>

</body>
</html>
