<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 03.03.19
  Time: 14:35
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
    <title>Document</title>

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
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                bądź celu ich pomocy.
            </p>
            <p data-step="4">
                Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
                wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="5">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/5</div>

        <form:form modelAttribute="donationForm" action="user/donations/formStep1" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <form:checkboxes delimiter="<br/>" path="giftTypeList" multiple="true" items="${giftTypeList}"
                                 itemLabel="giftType" itemValue="id"/><form:errors path="giftTypeList"/>
                <div class="form-group form-group--checkbox">
                    <label>
                        <input
                                type="checkbox"
                                name="products[]"
                                value="clothes-to-use"
                        />
                        <span class="checkbox"></span>
                        <span class="description"
                        >ubrania, które nadają się do ponownego użycia</span
                        >
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input
                                type="checkbox"
                                name="products[]"
                                value="clothes-useless"
                        />
                        <span class="checkbox"></span>
                        <span class="description">ubrania, do wyrzucenia</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="products[]" value="toys"/>
                        <span class="checkbox"></span>
                        <span class="description">zabawki</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="products[]" value="books"/>
                        <span class="checkbox"></span>
                        <span class="description">książki</span>
                    </label>
                </div>

                <div class="form-group form-group--checkbox">
                    <label>
                        <input type="checkbox" name="products[]" value="other"/>
                        <span class="checkbox"></span>
                        <span class="description">inne</span>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                    <button><a href="/user/donations/formStep2">Step 2</a></button>
                </div>
            </div>

        </form:form>
    </div>
</section>

<footer>
    <jsp:include page="../fragments/footer.jsp"/>
    <%--<div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50">
                <input type="text" name="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
                <input type="text" name="surname" placeholder="Nazwisko" />
            </div>

            <div class="form-group">
            <textarea
                    name="message"
                    placeholder="Wiadomość"
                    rows="1"
            ></textarea>
            </div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"
            ><img src="images/icon-facebook.svg"
            /></a>
            <a href="#" class="btn btn--small"
            ><img src="images/icon-instagram.svg"
            /></a>
        </div>
    </div>--%>
</footer>

<%--<script src="../../js/app.js"></script>--%>
</body>
</html>
