<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 04.03.19
  Time: 17:34
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
    <title>Form Step 2</title>
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
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>

            <p data-step="2" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>

        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>2</span>/5</div>
        <form:form modelAttribute="donationForm" method="post">
            <!-- STEP 2 -->
            <div data-step="2" class="active">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="quantity" placeholder="${sessionScope.quantitySelected}" value="${sessionScope.quantitySelected}" required="true" type="number" min="1"/><form:errors
                            path="quantity"/>
                        <%--<input type="number" name="bags" step="1" min="1"/>
                    </label>
                </div>--%>

                <div class="form-group form-group--buttons">
                    <a href="${pageContext.request.contextPath}/user/donations/formStep1" class="btn prev-step">Wstecz</a>
                    <button type="submit" class="btn next-step">Dalej</button>
                    <%--<a href="/user/donations/formStep3">Step 3</a>--%>

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