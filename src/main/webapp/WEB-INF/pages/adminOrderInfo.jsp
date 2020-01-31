<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Грузоперевозки</title>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/transport_war/webres/css/style.css">
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<h1 class="info-h1">${info}</h1>
<c:forEach items="${info2}" var="order">
    <div id="item${order.id}">
        <h1>Заказ №${order.id}</h1>
        <h2>Направление: ${order.nameRoute}</h2>
        <h2>Стоимость доставки(USD): ${order.totalCoast}</h2>
        <h4>Номер трассы: ${order.wayId}</h4>
        <h4>Масса груза (кг): ${order.weight}</h4>
        <hr>
    </div>
</c:forEach>


<form class="info-form-main-btn" action="${pageContext.request.contextPath}/adminMain">
    <input type="submit" value="На главную"/>
</form>

</body>
</html>