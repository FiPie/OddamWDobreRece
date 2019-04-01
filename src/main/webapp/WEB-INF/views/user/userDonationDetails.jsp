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
            <p>${donation.id}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">charity name</em>
            <p>${donation.charity.charityName}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">charity type</em>
            <p>${donation.charity.charityActivityType.organizationActivity}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">List of gifts</em>
            <c:forEach items="${donation.giftTypeList}" var="gifts">
                <p>${gifts.giftType.toString()}</p>
            </c:forEach>
        </div>
    <%--</div>

    <div class="container container--85">--%>
        <div class="stats--item">
            <em style="font-size: medium">Number of 60l bags</em>
            <p>${donation.quantity}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">donation creation date</em>
            <p>${donation.creationDate}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">pickup day</em>
            <p>${donation.pickUpDate}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">pickup hour</em>
            <p>${donation.pickUpHour}</p>
        </div>

        <div class="stats--item">
            <em style="font-size: medium">already delivered?</em>
            <p>${donation.giftPickedUp}</p>
        </div>

    </div>
</section>


<footer>
    <jsp:include page="../../fragments/footer.jsp"/>
</footer>
</body>
</html>
