<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 04.04.19
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of Donations</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menu.jsp"/>

</header>

<section class="stats">
    <div class="container container--85">

        <div class="stats--item">
            <table>
                <thead>
                <em style="font-size: xx-large">Donation date</em>
                </thead>

                <td>
                    <c:forEach var="donation" items="${donations}">
                        <tr><p>${donation.creationDate}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em style="font-size: xx-large">Organization Name</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${donations}">
                        <tr><p>${donation.charity.charityName}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em style="font-size: xx-large">Delivered?</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${donations}">
                        <tr><p>${donation.giftPickedUp}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em style="font-size: xx-large">Delivery date:</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${donations}">
                        <tr><p>${donation.pickUpDate}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em style="font-size: xx-large">Details</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${donations}">
                        <tr><p><a href="/admin/donationDetails${donation.id}" class="btn--without-border">details</a></p></tr>
                    </c:forEach>
                </td>
            </table>

        </div>


    </div>
</section>donations

<footer>
    <jsp:include page="../../fragments/footer.jsp"/>
</footer>
</body>
</html>
