<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 25.02.19
  Time: 12:42
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
    <title>Edit Organization</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: EDIT Organization </h1>

<section class="login-page">
    <h2>Organizacja do Edycji</h2>
    <form:form modelAttribute="orgToEdit" action="/admin/editOrganization" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Nazwa</td>
                    <td>Miasto</td>
                    <td>Komu pomagamy?</td>
                    <td>Akceptowane dary</td>
                    <td>Rodzaj prowadzonej działalności</td>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${toEdit.id}</td>
                    <td>${toEdit.charityName}</td>
                    <td>${toEdit.city}</td>
                    <td>${toEdit.charityActivityType.organizationActivity}</td>
                    <td>
                        <c:forEach items="${toEdit.acceptedGiftTypes}" var="giftType">
                            ${giftType.giftType.toString()},
                        </c:forEach>
                    </td>
                    <td>${toEdit.charityStructureType.organizationType}</td>
                </tr>

                <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                <div class="form-group"><form:input path="charityName" placeholder="${toEdit.charityName}"
                                                    required="true"/><form:errors path="charityName"/></div>
                <div class="form-group"><form:input path="city" placeholder="${toEdit.city}"
                                                    required="true"/><form:errors path="city"/></div>
                <div class="form-group">
                    <form:radiobuttons delimiter="<br/>" path="charityActivityType" items="${charityActivityList}"
                                       itemLabel="organizationActivity"
                                       itemValue="id"/><form:errors path="charityActivityType"/></div>
                <div class="form-group">
                    <form:checkboxes delimiter="<br/>" path="acceptedGiftTypes" multiple="true" items="${giftTypeList}"
                                     itemLabel="giftType" itemValue="id"/><form:errors path="acceptedGiftTypes"/></div>
                <div class="form-group">
                    <form:radiobuttons delimiter="<br/>" path="charityStructureType" items="${charityTypeList}"
                                       itemLabel="organizationType" itemValue="id"/><form:errors
                        path="charityStructureType"/></div>
                </tbody>
            </table>
            <table>
                <tr>
                    <td>
                        <button class="btn" type="submit">Zatwierdź zmiany</button>
                    </td>
                    <td><a href="/admin/orgList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
                </tr>
            </table>

        </div>
    </form:form>
</section>


</body>
</html>