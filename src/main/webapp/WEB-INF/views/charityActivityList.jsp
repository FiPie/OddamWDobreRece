<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 01.03.19
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Activity List</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: CHARITY ACTIVITY LIST </h1>
<section class="steps">
    <h2>CHARITY ACTIVITIES</h2>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Komu pomagamy?</td>
                    <td>Usunięcie</td>
                    <td>Edycja</td>
                </tr>
                </thead>
                <c:forEach var="activity" items="${charityActivityList}">
                    <tbody>
                    <tr>
                        <th scope="row">${activity.id}</th>
                        <td scope="row">${activity.organizationActivity}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/admin/${activity.id}/confirmDeleteCharityActivity" class="btn btn--small"> Usuń </a>
                            </div>
                        </td>
                        <td>
                            <div>
                                <a href="/admin/${activity.id}/editCharityActivity" class="btn btn--small">Edytuj</a>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/admin/charityActivityForm" class="btn btn--large">Dodaj Nowy Rodzaj Aktywności Charytatywnej</a>
            </div>
            <div class="steps--item">
                <a href="/admin/dashboard" class="btn btn--large">Wstecz</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>
