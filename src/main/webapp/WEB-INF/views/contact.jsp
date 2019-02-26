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
<html>
<head>
    <title>Kontakt</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>

<header>
    <jsp:include page="fragments/menu.jsp"/>
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
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię"/></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko"/></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="https://www.facebook.com" class="btn btn--small"><img src="images/icon-facebook.svg"/></a> <a href="https://www.instagram.com/?hl=pl"
                                                                                            class="btn btn--small"><img
                src="images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

<script src="js/app.js"></script>


</body>
</html>
