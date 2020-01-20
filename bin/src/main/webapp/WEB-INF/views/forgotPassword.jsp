<%--
  Created by IntelliJ IDEA.
  User: filippie
  Date: 18.03.19
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <style><%@include file="../../css/style.css" %>
    </style>
    <title>Forgot My Password</title>
</head>
<body>
<header>
    <jsp:include page="../fragments/menu.jsp"/>
</header>
<h2>Zapomniał(a/e)ś Hasła do Swojego Konta?<br></h2>
<h3 align="center">Żaden problem, podaj swój adres email, który został użyty przy rejestracji a my wyślemy na niego link do restartu hasła</h3>


<section class="login-page">
    <form:form method="post" modelAttribute="passwordReset">
        <div class="form-group">
            <form:input path="email" type="email" required="true" placeholder="Email"/><form:errors path="email"/>
        </div>
        <button class="btn btn--small btn--without-border reset-password" type="submit">resetuj hasło</button>
    </form:form>

    <div class="form-group form-group--buttons">
        <a href="${pageContext.request.contextPath}/register" class="btn btn--without-border">
            Załóż konto</a>
        <a href="${pageContext.request.contextPath}/login" class="btn">Zaloguj się</a>
    </div>
</section>
<%--<script src="jquery.min.js"></script>
<script th:inline="javascript">
    var serverContext = [[@{/}]];
        function resetPass(){
            var email = $("#email").val();
            $.post(serverContext + "user/resetPassword",{email: email} ,
                function(data){
                    window.location.href =
                        serverContext + "login?message=" + data.message;
                })
                .fail(function(data) {
                    if(data.responseJSON.error.indexOf("MailError") > -1)
                    {
                        window.location.href = serverContext + "emailError.html";
                    }
                    else{
                        window.location.href =
                            serverContext + "login?message=" + data.responseJSON.message;
                    }
                });
        }

</script>--%>
<footer>
    <jsp:include page="../fragments/footer.jsp"/>
</footer>
</body>

</html>
