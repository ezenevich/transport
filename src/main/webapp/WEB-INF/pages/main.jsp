<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Транспорт Клиент</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/transport_war/webres/css/adminStyle.css">

    <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>

    <div>

        <c:choose>
            <c:when test="${empty order}">
                <h1 align="center">Увас еще нет заказа.</h1>
            </c:when>

            <c:otherwise>
                <h1 id="label-of-list">Ваш заказ</h1>
                <hr>
                    <div id="item${order.id}">
                        <h1>Заказ №${order.id}</h1>
                        <h2>Направление: ${order.nameRoute}</h2>
                        <h4>Тип транспорта: ${order.type}</h4>
                        <h2>Время доставки(час): ${order.totalTime}</h2>
                        <h2>Стоимость доставки(USD): ${order.totalCoast}</h2>
                        <h4>Номер трассы: ${order.wayId}</h4>
                        <h4>Заказчик: ${order.userName}</h4>
                        <h4>Масса груза (кг): ${order.weight}</h4>
                        <h4>Статус доставки: ${order.delivery}</h4>
                        <hr>
                    </div>

            </c:otherwise>
        </c:choose>

        <div class="main-but-order">
            <a href="${pageContext.request.contextPath}/userRouteSelection">
                <input type="submit" class="create-sub cr-but" value="Сделать заказ"/>
            </a>
        </div>


        <div class="main-but-exit">
            <a href="${pageContext.request.contextPath}/index.jsp">
                <input class="create-sub" type="submit" value="Выход"/>
            </a>
        </div>

    </div>
</body>
</html>
