<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 30.03.19
  Time: 08:35
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

<h2> ${user.firstName}'s Donations </h2>

<div class="steps--container">
    <div class="steps--item">
        <table class="table table-bordered table-striped">

            <tr>

            </tr>

            <tr>
                <td>Oto lista Twoich darowizn</td>
                <td> ${user.firstName} ${user.lastName} </td>
            </tr>
            <tr>
                <td>Twój obecny adres email to:</td>
                <td> ${user.email} </td>
            </tr>

        </table>
    </div>
</div>
<section class="stats">
    <div class="container container--85">

        <div class="stats--item">
            <table>
                <thead>
                <em>Donation</em>
                </thead>

                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p>${donation.creationDate}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em>Organizacja</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p>${donation.charity.charityName}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em>Odbr?</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p>${donation.giftPickedUp}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em>Kiedy?</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p>${donation.pickUpDate}</p></tr>
                    </c:forEach>
                </td>
            </table>
        </div>

        <div class="stats--item">
            <table>
                <thead>
                <em>Szczegóły</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p><a href="/user/donationDetails/${donation.id}">details</a></p></tr>
                    </c:forEach>
                </td>
            </table>

        </div>


    </div>
</section>

<footer>
    <jsp:include page="../../fragments/footer.jsp"/>
</footer>
</body>
</html>