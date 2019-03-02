<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 24.02.19
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Password Change</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menu.jsp"/>
</header>

<h2> ${LoggedUser.firstName} PASSWORD CHANGE </h2>

<section class="login-page">
    <form:form modelAttribute="userToEdit" action="/user/changePassword" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Imię</td>
                    <td>Naziwsko</td>
                    <td>Email</td>
                    <td>Aktywny</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${LoggedUser.id}</td>
                    <td>${LoggedUser.firstName}</td>
                    <td>${LoggedUser.lastName}</td>
                    <td>${LoggedUser.email}</td>
                    <td>${LoggedUser.enabled}</td>
                </tr>

                <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                <div class="form-group"><form:hidden path="firstName" required="true"/><form:errors path="firstName"/></div>
                <div class="form-group"><form:hidden path="lastName" required="true"/><form:errors path="lastName"/></div>
                <div class="form-group"><form:hidden path="email" required="true"/><form:errors path="email"/></div>
                <div class="form-group"><form:password path="password" placeholder="Hasło" required="true"/><form:errors path="password"/></div>
                <div class="form-group"><form:password path="confirmedPassword" placeholder="Powtórz hasło" required="true"/><form:errors path="confirmedPassword"/></div>
                <div class="form-group"><form:hidden path="enabled"/><form:errors path="enabled"/></div>

                </tbody>
            </table>
            <table>
                <tr>
                    <td>
                        <button class="btn" type="submit">Zatwierdź zmiany</button>
                    </td>
                    <td><a href="/user/settings" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
                </tr>
            </table>

        </div>
    </form:form>
</section>

</body>
</html>
