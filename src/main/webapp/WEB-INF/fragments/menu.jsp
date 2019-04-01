<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 17.02.19
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="container container--70">

    <ul class="nav--actions">
        <sec:authorize access="!isAuthenticated()">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a href="/logout" class="btn btn--small btn--without-border">Wyloguj</a></li>
        </sec:authorize>


        <sec:authorize access="isAuthenticated()">
            <li class="logged-user">
                Witaj ${userFirstName}
                <ul class="dropdown">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li><a href="/user/dashboard">Profil</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/dashboard">Admin</a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li><a href="/user/settings">Ustawienia</a></li>
                        <li><a href="/user/donations/formStep1">Oddaj rzeczy</a></li>
                        <li><a href="/user/listOfDonations">Moje zbiórki</a></li>
                    </sec:authorize>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </sec:authorize>

    </ul>


    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/about" class="btn btn--without-border">O nas</a></li>
        <li><a href="/orgList" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="/contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>

</nav><%--
<style>
    <%@include file="../../css/style.css" %>
</style>--%>
