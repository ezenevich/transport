<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="http://localhost:8080/kursovoi_war/webres/css/style.css">
    <title>Истоия</title>
</head>
<body>
<div>
    <h1 align="center">История ${user.login}</h1>

</div>
<div>
    <form action="${pageContext.request.contextPath}/main" class="form-startpage">
        <input type="submit" value="На главную">
    </form>
</div>
<div class="useracc-fav-items-div">
    <c:choose>
        <c:when test="${empty items}">
            Список ранее просмотренных объявлений:
        </c:when>
        <c:otherwise>
            <h1 id="label-of-list">Item:</h1>
            <hr>
            <c:forEach items="${items}" var="i">
                <div id="item${i.id}">
                    <a href="${pageContext.request.contextPath}/item?id=${i.id}&owner=${i.owner}">
                        <h1>${i.name}</h1>
                        <img src="${i.smallimg}"/>
                    </a>
                    <h5>Описание: ${i.about}</h5>
                    <h5>Категория: ${i.category}</h5>
                    <h5>Владелец: ${i.owner}</h5>
                    <h3>Цена: ${i.price} USD</h3>
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
