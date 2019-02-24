<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 24.02.19
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menu.jsp"/>
</header>

<h2> ${LoggedUser.firstName} DASHBOARD </h2>

<div class="steps--container">
    <div class="steps--item">
        <table class="table table-bordered table-striped">

            <tr>

            </tr>

            <tr>
                <td>Witaj w swoim panelu głównym </td>
                <td> ${LoggedUser.firstName} ${LoggedUser.lastName} </td>
            </tr>
            <tr>
                <td>Twój obecny adres email to:</td>
                <td> ${LoggedUser.email} </td>
            </tr>

        </table>
    </div>
</div>
<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>10</em>
            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>5</em>
            <h3>Wspartych organizacji</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

        <div class="stats--item">
            <em>7</em>
            <h3>Zorganizowanych zbiórek</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quos dolores commodi error. Natus, officiis
                vitae?</p>
        </div>
    </div>
</section>

</body>
</html>