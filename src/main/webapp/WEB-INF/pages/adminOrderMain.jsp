<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Сотрудник заказы</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/transport_war/webres/css/adminStyle.css">

    <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>


    <div class="main-but-rout">
        <a href="${pageContext.request.contextPath}/orderOut">
            <input type="submit" class="create-sub cr-but" value="Загрузка"/>
        </a>
    </div>

    <div class="main-but-way">
        <a href="${pageContext.request.contextPath}/orderIn">
            <input type="submit" class="create-sub cr-but" value="Приёмка"/>
        </a>
    </div>

    <div class="main-but-sector">
        <a href="${pageContext.request.contextPath}/allOrders">
            <input type="submit" class="create-sub cr-but" value="Список заказов"/>
        </a>
    </div>


    <div class="main-but-exit">
        <a href="${pageContext.request.contextPath}/adminMain">
            <input class="create-sub" type="submit" value="назад"/>
        </a>
    </div>

</body>
</html>
