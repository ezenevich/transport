<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/transport_war/webres/css/style.css" >
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/adminReg"  method="POST" class="register-form" >
            <table>
            <tr><td>Логин:</td><td> <input type="text" name="login" required/></td></tr><br>
            <tr><td>Пароль:</td><td> <input type="password" name="pass" required/></td></tr><br>
            <tr><td colspan="2"><input type="submit" value="Зарегистрироваться" id="register-form-input-register"/></td></tr>
            </table>
        </form><hr>
        <form action="${pageContext.request.contextPath}/adminLogin" class="register-form-startpage">
            <input type="submit" value="На главную"/>
        </form>
    </body>
</html>