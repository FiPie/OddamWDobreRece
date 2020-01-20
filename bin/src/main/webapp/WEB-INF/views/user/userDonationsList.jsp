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
                <em style="font-size: xx-large">Donation date</em>
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
                    <em style="font-size: xx-large">Organization Name</em>
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
                    <em style="font-size: xx-large">Delivered?</em>
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
                    <em style="font-size: xx-large">Delivery date:</em>
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
                    <em style="font-size: xx-large">Details</em>
                </thead>
                <td>
                    <c:forEach var="donation" items="${userDonations}">
                        <tr><p><a href="/user/donationDetails${donation.id}" class="btn--without-border">details</a></p></tr>
                    </c:forEach>
                </td>
            </table>

        </div>


    </div>
</section>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>

        <form:form class="form--contact" modelAttribute="message" method="post" action="/">
            <div class="form-group form-group--50"><form:input readonly="true" value="${user.firstName}" path="firstName2" type="text" name="name"/></div>
            <div class="form-group form-group--50"><form:input readonly="true" value="${user.lastName}" path="lastName2" type="text" name="surname"/></div>

            <div class="form-group"><form:textarea path="content" name="message" placeholder="Wiadomość" rows="4"/></div>
            <form:hidden path="email2" value="${user.email}"/>
            <button class="btn" type="submit">Wyślij</button>
        </form:form>

    </div>

    <jsp:include page="../../fragments/footer.jsp"/>
</footer>
</body>
</html>