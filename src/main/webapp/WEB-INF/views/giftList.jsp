<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 19.02.19
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<html>
<head>
    <title>Gift List</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: GIFT LIST </h1>
<section class="steps">
    <h2>GIFTS</h2>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Rodzaj przekazywanej pomocy</td>
                    <td>Usunięcie</td>
                    <td>Edycja</td>
                </tr>
                </thead>
                <c:forEach var="charity" items="${giftList}">
                    <tbody>
                    <tr>
                        <th scope="row">${charity.id}</th>
                        <td scope="row">${charity.giftType}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/admin/${charity.id}/confirmDeleteGift" class="btn btn--small"> Usuń </a>
                            </div>
                        </td>
                        <td>
                            <div>
                                <a href="/admin/${charity.id}/editGift" class="btn btn--small">Edytuj</a>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/admin/giftTypeForm" class="btn btn--large">Dodaj Nowy Rodzaj Darowizny</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>
