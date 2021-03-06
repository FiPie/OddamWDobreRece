<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 31.03.19
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Donation Details</title>
    <style>
        <%@include file="../../../css/style.css" %>
    </style>
</head>
<body>
<header>
    <jsp:include page="../../fragments/menu.jsp"/>

</header>

<h2> Details of ${user.firstName}'s Donation </h2>


<section class="stats">
    <div class="container container--85">

        <div class="stats--item">
            <em style="font-size: medium">id</em>
            <b style="font-size: large"><br><br><br>${donation.id}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">charity name</em>
            <b style="font-size: medium"><br><br>${donation.charity.charityName}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">charity type</em>
            <b style="font-size: medium"><br><br><br>${donation.charity.charityActivityType.organizationActivity}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">List of gifts</em>
            <c:forEach items="${donation.giftTypeList}" var="gifts">
                <b style="font-size: medium"><br><br>${gifts.giftType.toString()}</b>
            </c:forEach>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">Number of 60l bags</em>
            <b style="font-size: large"><br>${donation.quantity}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">donation creation date</em>
            <b style="font-size: medium"><br><br><br>${donation.creationDate}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">pickup day</em>
            <b style="font-size: medium"><br><br><br>${donation.pickUpDate}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">pickup hour</em>
            <b style="font-size: large"><br><br>${donation.pickUpHour}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">last modification</em>
            <b style="font-size: medium"><br><br><br>${donation.statusChangeDate}</b>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">already delivered?</em>
            <b style="font-size: medium"><br><br>${donation.giftPickedUp}</b>
            <form:form modelAttribute="donationDto" method="post" action="/user/donationDetails">
                <form:hidden path="id"/><form:errors path="id"/>
                <form:checkbox path="giftPickedUp" label="check if picked up"/><form:errors path="giftPickedUp"/>

                <button type="submit">change status!</button>
            </form:form>
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
