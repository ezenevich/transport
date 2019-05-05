<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <link rel="stylesheet" type="text/css"
              href="http://localhost:8080/kursovoi_war/webres/css/style.css">
    </head>
    <body class="loginpage">
        <form action="${pageContext.request.contextPath}/login" method="POST" class="login-form">
            <table>
                <tr><td>Логин:</td><td><input type="text" id="login" name="login"/><br></td> </tr>
                <tr><td>Пароль:</td><td><input type="password" name="pass"/></td> </tr><br>
                <tr><td colspan="2"><input type="submit" value="Войти" id="login-form-input-LogIn" onclick="setLogin()"/></td></tr>
            </table>
            <script>
                function setLogin() {
                    var login = document.getElementById('login').value
                    localStorage.setItem('currentLogin', JSON.stringify(login));
                }
            </script>
        </form><hr>
        <div class="login-div-form">
            <table>
                <tr>
                    В первый раз? Зарегистрируйтесь
                <form action="${pageContext.request.contextPath}/register">
                    <input type="submit" value="Регистрация"/>
                </form>
                </tr>
                <tr>
                    , или же перейдите
                <form action="${pageContext.request.contextPath}/main">
                    <input type="submit" value="На главную"/>
                </form>
                </tr>
            </table>
        </div>
    </body>
</html>