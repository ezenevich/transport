<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Владелец</title>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/kursovoi_war/webres/css/style.css">
</head>
<body>
<div>
    <h1>Владелец: ${user.login}</h1><br>
    <h1>Телефон: ${user.phone}</h1>
    <form action="${pageContext.request.contextPath}/main" class="form-startpage">
        <input type="submit" value="На главную"/>
    </form>
</div>
<hr>
<div>
    <h1>Обьявления владельца:</h1>
    <hr>
    <div class="single-owner-items-div">
        <c:forEach items="${items}" var="i">
            <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                <h1>${i.name}</h1>
                <img src="${i.smallimg}"/>
            </a>
            <h5>Описание: ${i.about}</h5>
            <h5>Категория: ${i.category}</h5>
            <h3>Цена: ${i.price} USD</h3>
            <hr>
        </c:forEach>
    </div>
</div>
</body>
</html>
