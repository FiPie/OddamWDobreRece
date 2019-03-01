<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 26.02.19
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Kontakt</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>

<header>
    <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <jsp:include page="fragments/menu.jsp"/>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <jsp:include page="fragments/menuAdmin.jsp"/>
    </sec:authorize>
</header>


<section class="about-us">
    <div class="about-us--text">
        <h2>Adres siedziby OddamWDobreRece</h2>
        <p>Ul. Emilii Plater 103 00-113 Warszawa, województwo MAZOWIECKIE</p>
        <p>Telefon +48222071902</p>
        <p>Numer NIP 5252344079</p>
        <p>Numer REGON 140182842</p>
        <p>Numer KRS 000024062</p>
        <img src="images/signature.svg" alt="Signature">
        <%--<img src="/WEB-INF/views/images/signature.svg" class="about-us--text-signature" alt="Signature"/>--%>
    </div>
    <div class="about-us--image">
        <img src="images/about-us.jpg" alt="People in circle">
        <%--<img src="images/about-us.jpg" alt="People in circle"/>--%>
    </div>
</section>


<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

<script src="js/app.js"></script>


</body>
</html>
