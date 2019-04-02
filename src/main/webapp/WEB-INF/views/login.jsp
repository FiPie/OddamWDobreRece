<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 17.02.19
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Login</title>
    <style><%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menu.jsp"/>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form modelAttribute="loginFormDto" method="post" action="/login">
        <c:if test="${param['error'] != null}">
            <p>Błędne login/hasło!</p>
        </c:if>
        <div class="form-group">
            <form:input path="email" type="email" required="true" placeholder="Email" /><form:errors path="email"/>
        </div>

        <div class="form-group">
            <form:password path="password" required="true" placeholder="Hasło" /><form:errors path="password"/>
            <a href="/forgotPassword" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>
</section>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>

        <form:form class="form--contact" modelAttribute="message" method="post" action="/">
            <div class="form-group form-group--50"><form:input path="firstName2" type="text" name="name"
                                                               placeholder="Imię"/></div>
            <div class="form-group form-group--50"><form:input path="lastName2" type="text" name="surname"
                                                               placeholder="Nazwisko"/></div>

            <div class="form-group"><form:textarea path="content" name="message" required="true" placeholder="Wiadomość"
                                                   rows="4"/></div>

            <div class="form-group"><form:input path="email2" type="email" required="true" placeholder="Email address"/></div>
            <button class="btn" type="submit">Wyślij</button>
        </form:form>

    </div>
    <jsp:include page="../fragments/footer.jsp"/>
</footer>
</body>
</html>
