<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 19.02.19
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Organization List</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <jsp:include page="fragments/menuAdmin.jsp"/>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <jsp:include page="fragments/menu.jsp"/>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
        <jsp:include page="fragments/menu.jsp"/>
    </sec:authorize>
</header>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <h1> ADMIN DASHBOARD: ORGANIZATION LIST </h1>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <h1> USER DASHBOARD: ORGANIZATION LIST </h1>
</sec:authorize>

<section class="steps">
    <h2>ORGANIZATIONS</h2>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Nazwa</td>
                    <td></td>
                    <td>Miasto</td>
                    <td>Komu pomagamy?</td>
                    <td>Co ofiarować?</td>
                    <td>Rodzaj organizacji</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td>Usunięcie</td>
                        <td>Edycja</td>
                    </sec:authorize>
                </tr>
                </thead>
                <c:forEach var="charity" items="${organizationList}">
                    <tbody>
                    <tr>
                        <th scope="row">${charity.id}</th>
                        <td scope="row">${charity.charityName}</td>
                        <td></td>
                        <td scope="row">${charity.city}</td>
                        <td scope="row">${charity.charityStructureType.organizationType}</td>
                        <td scope="row">
                            <c:forEach items="${charity.acceptedGiftTypes}" var="gift">
                                ${gift.giftType.toString()},
                            </c:forEach></td>
                        </td>
                        <td>${charity.charityStructureType.organizationType}</td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td scope="row">
                                <div class="form-group form-group--buttons">
                                    <a href="/admin/${charity.id}/confirmDeleteOrganization" class="btn btn--small">
                                        Usuń </a>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <a href="/admin/${charity.id}/editOrganization" class="btn btn--small">Edytuj</a>
                                </div>
                            </td>
                        </sec:authorize>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="steps--item">
                    <a href="/admin/organizationForm" class="btn btn--large">Dodaj Nową Organizację</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</section>
</body>
</html>