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
<html>
<head>
    <title>Organization List</title>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="fragments/menuAdmin.jsp"/>
</header>
<h2> ADMIN DASHBOARD: ORGANIZATION LIST </h2>
<section class="steps">
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Nazwa</td>
                    <td>  </td>
                    <td>Miasto</td>
                    <td>Rodzaj</td>
                    <td>Usunięcie</td>
                    <td>Edycja</td>
                </tr>
                </thead>
                <c:forEach var="org" items="${organizationList}">
                    <tbody>
                    <tr>
                        <th scope="row">${org.id}</th>
                        <td scope="row">${org.charityName}</td>
                        <td>  </td>
                        <td scope="row">${org.city}</td>
                        <td scope="row">${org.type}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/admin/${org.id}/confirmDeleteOrganization" class="btn btn--small"> Usuń </a>
                            </div>
                        </td>
                        <td>
                            <div>
                                <a href="/admin/${org.id}/editOrganization" class="btn btn--small">Edytuj</a>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/admin/organizationForm" class="btn btn--large">Dodaj Nową Organizację</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>