<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 04.03.19
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Form Step 6</title>
    <link rel="stylesheet" href="../../../css/style.css"/>
</head>
<body>
<header class="header--form-page">
    <sec:authorize access="hasRole('ROLE_USER')">
        <jsp:include page="../../fragments/menu.jsp"/>
    </sec:authorize>


    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br/>
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<section class="form--steps">


    <div class="form--steps-container">
        <form:form modelAttribute="donationForm" method="post">
            <!-- STEP 6 -->
            <div data-step="6" class="active">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                        ${sessionScope['quantitySelected']} worki
                                            <c:forEach var="gifts" items="${sessionScope.giftTypesSelected}">
                                                <span>${gifts.giftType},</span>
                                            </c:forEach>

                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla: ${sessionScope.selectedCharity.charityName}</span
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li>${form5.street} </li>
                                <li>${form5.city}</li>
                                <li>${form5.postCode}</li>
                                <li>${form5.phone}</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li>${form5.pickUpDate}</li>
                                <li>${form5.pickUpHour}</li>
                                <li>${form5.notes}</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div>
                    <form:hidden path="quantity" value="${quantity}" /><form:errors path="quantity"/>
                    <c:forEach items="${giftTypeList}" var="giftType">
                        <form:hidden path="giftTypeList" value="${giftType.longValue()}"/>
                    </c:forEach>
                    <%--<form:hidden path="giftTypeList"  items="${giftTypeList}"/><form:errors path="giftTypeList"/>--%>
                    <form:hidden path="user" value="${donatingUser.id}"/><form:errors path="user"/>
                    <form:hidden path="charity" value="${charity.id}" /><form:errors path="charity"/>
                    <form:hidden path="pickUpDate" value="${form5.pickUpDate}" /><form:errors path="pickUpDate"/>
                    <form:hidden path="pickUpHour" value="${form5.pickUpHour}" /><form:errors path="pickUpHour"/>
                    <form:hidden path="city" value="${form5.city}" /><form:errors path="city"/>
                    <form:hidden path="street" value="${form5.street}" /><form:errors path="street"/>
                    <form:hidden path="postCode" value="${form5.postCode}" /><form:errors path="postCode"/>
                    <form:hidden path="phone" value="${form5.phone}" /><form:errors path="phone"/>
                    <form:hidden path="notes" value="${form5.notes}" /><form:errors path="notes"/>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="${pageContext.request.contextPath}/user/donations/formStep5"
                       class="btn prev-step">Wstecz</a>
                    <button type="submit" class="btn">Potwierdzam</button>

                </div>
            </div>

        </form:form>
    </div>

</section>


<footer>
    <jsp:include page="../../fragments/footer.jsp"/>
</footer>


<%--<script src="../../js/app.js"></script>--%>


</body>
</html>
