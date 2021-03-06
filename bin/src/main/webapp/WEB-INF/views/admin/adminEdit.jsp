<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 20.02.19
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Admin</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menuAdmin.jsp"/>
</header>
<h1> ADMIN DASHBOARD: EDIT ADMIN </h1>

<section class="login-page">
    <form:form modelAttribute="adminToEdit" action="/admin/editAdmin" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Imię</td>
                    <td>Naziwsko</td>
                    <td>Email</td>
                    <td>Password</td>
                    <td>Confirm Password</td>
                    <td>Aktywny</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${toEdit.id}</td>
                    <td>${toEdit.firstName}</td>
                    <td>${toEdit.lastName}</td>
                    <td>${toEdit.email}</td>
                    <td>***********</td>
                    <td>***********</td>
                    <td>${toEdit.enabled}</td>
                </tr>

                    <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                    <div class="form-group"><form:input path="firstName" placeholder="${toEdit.firstName}" required="true"/><form:errors path="firstName"/></div>
                    <div class="form-group"><form:input path="lastName" placeholder="${toEdit.lastName}" required="true"/><form:errors path="lastName"/></div>
                    <div class="form-group"><form:input path="email" type="email" placeholder="${toEdit.email}" required="true"/><form:errors path="email"/></div>
                    <div class="form-group"><form:password path="password" placeholder="Hasło" required="true"/><form:errors path="password"/></div>
                    <div class="form-group"><form:password path="confirmedPassword" placeholder="Powtórz hasło" required="true"/><form:errors path="confirmedPassword"/></div>
                    <div class="form-group"><form:checkbox path="enabled"/>${toEdit.enabled}<form:errors path="enabled"/></div>

                </tbody>
            </table>
            <table>
                <tr>
                    <td>
                        <button class="btn" type="submit">Zatwierdź zmiany</button>
                    </td>
                    <td><a href="/admin/adminList" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
                </tr>
            </table>

        </div>
    </form:form>
</section>


</body>
</html>
