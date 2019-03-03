<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 17.02.19
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Homepage</title>
    <style>
        <%@include file="../../css/style.css" %>
    </style>
</head>
<body>

<header class="header--main-page">
    <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <jsp:include page="../fragments/menu.jsp"/>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <jsp:include page="../fragments/menuAdmin.jsp"/>
    </sec:authorize>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>

            <ul class="slogan--buttons">
                <sec:authorize access="hasRole('ROLE_USER')"><li><a href="/user/donations/formStep1" class="btn btn--large">Oddaj rzeczy</a></li></sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="/admin/donations" class="btn btn--large">Oddaj rzeczy</a></li></sec:authorize>
                <sec:authorize access="isAnonymous()"><li><a href="/login" class="btn btn--large">Oddaj rzeczy</a></li></sec:authorize>
                <li><a href="#" class="btn btn--large">Zorganizuj zbiórkę</a></li>
            </ul>
        </div>
    </div>
</header>


<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>10</em>
            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>5</em>
            <h3>Wspartych organizacji</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

        <div class="stats--item">
            <em>7</em>
            <h3>Zorganizowanych zbiórek</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quos dolores commodi error. Natus, officiis
                vitae?</p>
        </div>
    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>
    <sec:authorize access="!isAuthenticated()">
        <a href="/register" class="btn btn--large">Załóż konto</a>
    </sec:authorize>
</section>

<section class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="images/signature.svg" alt="Signature">
        <%--<img src="/WEB-INF/views/images/signature.svg" class="about-us--text-signature" alt="Signature"/>--%>
    </div>
    <div class="about-us--image">
        <img src="images/about-us.jpg" alt="People in circle">
        <%--<img src="images/about-us.jpg" alt="People in circle"/>--%>
    </div>
</section>

<section class="help">
    <h2>Komu pomagamy?</h2>

    <ul class="help--buttons">
        <li data-id="1"><a href="#" class="btn btn--without-border active">Fundacjom</a></li>
        <li data-id="2"><a href="#" class="btn btn--without-border">Organizacjom pozarządowym</a></li>
        <li data-id="3"><a href="#" class="btn btn--without-border">Lokalnym zbiórkom</a></li>
    </ul>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy. Możesz sprawdzić czym się
            zajmują, komu pomagają i czego potrzebują.</p>

        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Fundacja "Dbam o Zdrowie"</div>
                    <div class="subtitle">Cel i misja: Pomoc dzieciom z ubogich rodzin.</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, jedzenie, sprzęt AGD, meble, zabawki</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Dla dzieci"</div>
                    <div class="subtitle">Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, meble, zabawki</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Bez domu”</div>
                    <div class="subtitle">Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania</div>
                </div>

                <div class="col">
                    <div class="text">ubrania, jedzenie, ciepłe koce</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
        </ul>
    </div>

    <!-- SLIDE 2 -->
    <div class="help--slides" data-id="2">
        <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Hic officiis mollitia dolor, neque aspernatur
            accusamus debitis. Ducimus, officia. Quia, sunt illum! Non iste placeat ab ipsum alias
            quos suscipit corporis!
        </p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Organizacja 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 3</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 4</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="4">4</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="5">5</a></li>
        </ul>
    </div>

    <!-- SLIDE 3 -->
    <div class="help--slides" data-id="3">
        <p>Lorem ipsum dolor sit amet, his ocurreret persequeris ea, ad utinam laudem duo. Verterem adipisci partiendo
            eos ne, ea his reque quaeque recteque, ne quo lobortis intellegam.</p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col">
                    <div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div>
                </div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
        </ul>
    </div>
</section>

<footer>
    <jsp:include page="../fragments/footer.jsp"/>
</footer>

<script src="../../js/app.js"></script>


</body>
</html>
