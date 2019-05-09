<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Записки.by</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/kursovoi_war/webres/css/style.css">

    <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>

<div class="main-control-menu">
    <div class="menu">
        <c:if test="${!isLogin}">
            <form action="${pageContext.request.contextPath}/register">
                <input type="submit" value="Регистрация"/>
            </form>
        </c:if>
        <c:if test="${isLogin}">

            <a href="${pageContext.request.contextPath}/create">
                <input type="submit" id="create-submit" value="Создать объявление"/>
            </a>
            <form action="${pageContext.request.contextPath}/userAccount">
                <input type='submit' id="cubinet-submit" value='Мой кабинет'/>
            </form>

            <hr>
            <div class="filter">
                <h3>Фильтрация:</h3>
                <form action="main">
                    Выберите категорию:<select name="category">
                    <option>all</option>
                    <option>phones</option>
                    <option>laptops</option>
                    <option>gadgets</option>
                    <option>consumer-electronics</option>
                    <option>shoes</option>
                    <option>clothing</option>
                    <option>sports-equipment</option>
                </select><br>
                    Введите логин:<input id="login-filter" name="login"/>
                    <input type="submit" id="log-fil-input" value="Принять"/>
                </form>

            </div>
            <hr>
            <a class="a-exit" href="${pageContext.request.contextPath}/login?exit=true">
                <input type="submit" value="Выход"/>
            </a>
        </c:if>
    </div>
    <div>
        <c:if test="${!isLogin}">
            <form action="${pageContext.request.contextPath}/login">
                <input type="submit" value="Авторизация"/>
            </form>
        </c:if>
    </div>
</div>
<div>
    <h1>Объявления:</h1>
    <hr>
    <c:forEach items="${items}" var="i">
        <table>
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                        <h1>${i.name}</h1>
                        <img src="${i.img}"  alt="фото"/>
                        <h5>${i.about}</h5>
                        <h3>Цена: ${i.price} USD</h3>
                    </a>
                    <h5><a href="${pageContext.request.contextPath}/owner?owner=${i.owner}">
                        Владелец: ${i.owner}
                    </a></h5>
                </td>
                    </table>

        <hr>
    </c:forEach>

</div>
</body>
</html>
