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
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Register</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
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
            <form:password path="confirmedPassword" placeholder="Powtórz hasło" required="true"/><form:errors
                path="confirmedPassword"/>
        </div>
        <form:errors path="*"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>


<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
