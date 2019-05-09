<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="http://localhost:8080/kursovoi_war/webres/css/style.css">
    <title>Личный кабинет</title>
</head>
<body>
<div>
    <h1 align="center">Добро пожаловать: ${user.login}</h1>

</div>
<div>
    <form action="${pageContext.request.contextPath}/main" class="form-startpage">
        <input type="submit" value="На главную">
    </form>
    <form action="${pageContext.request.contextPath}/userHistory" class="form-startpage">
        <input type="submit" value="История" style="margin-top: 20px">
    </form>
</div>
<div class="useracc-fav-items-div">
    <c:choose>
        <c:when test="${empty items}">
            Избранные записи:
        </c:when>
        <c:otherwise>
            <h1 id="label-of-list">Объявления</h1>
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
                    <button value='delete from favorites' onclick="deleteFromFavorits(${i.id})">удалить</button>
                    <hr>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
<script type="text/javascript">
    var itemsCount = ${items.size()};
    var label = document.getElementById("label-of-list");
    function deleteFromFavorits(id) {
        if (--itemsCount < 1) label.innerHTML = "Your favorites is empty";
        var item = document.getElementById("item" + id);
        item.remove();
        console.log(id);
        var request = "id=-" + id;
        console.log(request);
        fetch('${pageContext.request.contextPath}/userAccount', {
            method: 'POST',
            headers: {
                'Accept': 'application/json, application/xml, text/plain, text/html,',
                'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'
            },
            body: request
        }).catch(alert);
    }
</script>


<div>

</div>


</body>
</html>
