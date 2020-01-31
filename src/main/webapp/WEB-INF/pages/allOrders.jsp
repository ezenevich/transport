<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="http://localhost:8080/transport_war/webres/css/style.css">
    <title>Транспорт заказы</title>
</head>
<body>
<div>
    <h1 align="center">Список заказов</h1>
</div>
<div>
    <form action="${pageContext.request.contextPath}/adminMain" class="form-startpage">
        <input type="submit" value="На главную">
    </form>
</div>
<div class="useracc-fav-items-div">
    <c:choose>
        <c:when test="${empty orders}">
            <h1 align="center">Заказов нет</h1>
        </c:when>
        <c:otherwise>
            <hr>
            <c:forEach items="${orders}" var="order">
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
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>



<div>

</div>


</body>
</html>
