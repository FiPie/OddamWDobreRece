<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 02.03.19
  Time: 07:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Charity Type Edit</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: EDIT CHARITY TYPE </h1>

<section class="login-page">
    <h2>Forma Działalności ZI do Edycji</h2>
    <form:form modelAttribute="charityTypeToEdit" action="/admin/editCharityType" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Forma Działalności ZI</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${toEdit.id}</td>
                    <td>${toEdit.organizationType}</td>

                </tr>

                <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                <div class="form-group"><form:input path="organizationType" placeholder="${toEdit.organizationType}"
                                                    required="true"/><form:errors path="organizationType"/></div>

                </tbody>
            </table>
            <table>
                <tr>
                    <td>
                        <button class="btn" type="submit">Zatwierdź zmiany</button>
                    </td>
                    <td><a href="/admin/charityTypeList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
                </tr>
            </table>

        </div>
    </form:form>
</section>


</body>
</html>