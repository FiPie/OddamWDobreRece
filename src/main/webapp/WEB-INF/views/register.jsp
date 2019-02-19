<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 17.02.19
  Time: 13:08
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
    <title>Register</title>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />--%>
</head>
<body>
<header>
    <jsp:include page="fragments/menu.jsp"/>
</header>


<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="registrationForm" method="post">
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
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>


<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form>
            <div class="form-group form-group--50">
                <input type="text" name="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
                <input type="text" name="surname" placeholder="Nazwisko" />
            </div>

            <div class="form-group">
            <textarea
                    name="message"
                    placeholder="Wiadomość"
                    rows="1"
            ></textarea>
            </div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"
            ><img src="images/icon-facebook.svg"
            /></a>
            <a href="#" class="btn btn--small"
            ><img src="images/icon-instagram.svg"
            /></a>
        </div>
    </div>
</footer>

</body>
</html>
