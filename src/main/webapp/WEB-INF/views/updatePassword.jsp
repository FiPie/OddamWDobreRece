<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 20.03.19
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <style><%@include file="../../css/style.css" %>
    </style>
    <title>Reset Password</title>
</head>
<body>

<header>
    <jsp:include page="../fragments/menu.jsp"/>
</header>
<h2>Zapomniał(a/e)ś Hasła do Swojego Konta?<br></h2>


<section class="login-page">
    <sec:authorize access="hasAuthority('CHANGE_PASSWORD_PRIVILEGE')">
        <form:form method="post" action="/updatePassword" modelAttribute="passwordUpdate">

            <div class="form-group">
                <form:input path="password" type="password" required="true" placeholder="new password"/><form:errors
                    path="password"/>
            </div>
            <div class="form-group">
                <form:input path="confirmedPassword" type="password" required="true"
                            placeholder="confirm new password"/><form:errors path="confirmedPassword"/>
            </div>
            <button class="btn btn--small btn--without-border reset-password" type="submit">zapisz nowe hasło</button>
        </form:form>
    </sec:authorize>
    <div class="form-group form-group--buttons">
        <a href="${pageContext.request.contextPath}/register" class="btn btn--without-border">
            Załóż konto</a>
        <a href="${pageContext.request.contextPath}/login" class="btn">Zaloguj się</a>
    </div>
</section>


<footer>
    <jsp:include page="../fragments/footer.jsp"/>
</footer>
</body>
</html>
