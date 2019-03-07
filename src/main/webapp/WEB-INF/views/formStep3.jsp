<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 04.03.19
  Time: 15:53
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
    <title>Form Step 3</title>
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
            <p data-step="3" class="active">
                Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                bądź celu ich pomocy.
            </p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>3</span>/5</div>
        <form:form modelAttribute="charityForm" method="post">
            <!-- STEP 3 -->
            <div data-step="3" class="active">
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <form:select path="city" items="${cityList}"/><form:errors path="city"/>
                    <%--<select name="localization">
                        <option value="0">- wybierz -</option>
                        <option value="warsaw">Warszawa</option>
                        <option value="wroclaw">Wrocław</option>
                        <option value="poznan">Poznań</option>
                        <option value="gdansk">Gdańsk</option>
                    </select>--%>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div class="form-section--checkboxes">
                        <form:checkboxes path="charityActivityList" items="${charityActivityList}" itemValue="id" itemLabel="organizationActivity"/><form:errors path="charityActivityList"/>

                        <%--<div class="form-group form-group--checkbox">
                            <label>
                                <input type="checkbox" name="help[]" value="children"/>
                                <span class="checkbox">dzieciom</span>
                            </label>
                        </div>--%>
                    </div>
                </div>

                <div class="form-section">
                    <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
                    <div class="form-group">
                        <form:textarea rows="4" path="charityName"/><form:errors path="charityName"/>
                        <%--<textarea rows="4" name="organization_search"></textarea>--%>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="${pageContext.request.contextPath}/user/donations/formStep2" class="btn prev-step">Wstecz</a>
                    <button type="submit" class="btn next-step">Szukaj</button>
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
