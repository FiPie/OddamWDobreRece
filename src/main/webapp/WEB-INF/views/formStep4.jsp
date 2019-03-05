<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 04.03.19
  Time: 17:39
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
    <title>Form Step 4</title>
    <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<header class="header--form-page">
    <sec:authorize access="hasRole('ROLE_USER')">
        <jsp:include page="../fragments/menu.jsp"/>
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

            <p data-step="4" class="active">
                Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
                wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>

        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>4</span>/5</div>
        <form:form modelAttribute="donationForm" action="user/donations/formStep4" method="post">
            <!-- STEP 4 -->
            <div data-step="4" class="active">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="organization" value="old"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">Fundacja “Bez domu”</div>
                  <div class="subtitle">
                    Cel i misja: Pomoc dla osób nie posiadających miejsca
                    zamieszkania
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="radio" name="organization" value="old"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">Fundacja “Dla dzieci"</div>
                  <div class="subtitle">
                    Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji
                    życiowej.
                  </div>
                </span>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                    <a href="/user/donations/formStep5">Step 5</a>
                </div>
            </div>
        </form:form>
    </div>
</section>


<footer>
    <jsp:include page="../fragments/footer.jsp"/>
</footer>


<%--<script src="../../js/app.js"></script>--%>


</body>
</html>