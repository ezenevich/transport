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
<body onload="redirectTimeOut('${pageContext.request.contextPath}/userWaySelection');">
<h1 class="info-h1">${info}</h1>


<form class="info-form-main-btn" action="${pageContext.request.contextPath}/userWaySelection">
    <input type="submit" value="Продолжить"/>
</form>
<form class="info-form-redirect-timer">Вы будете перенаправленны для продолжения через: <span id="countdown">3</span>.
</form>
</body>
</html>