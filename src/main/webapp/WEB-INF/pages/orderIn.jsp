<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Приёмка</title>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/transport_war/webres/css/style.css">
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div id="create-div">

    <c:choose>
        <c:when test="${empty routes}">
            <span class="spanText">Груз ещё не прибыл</span>
        </c:when>

        <c:otherwise>
            <form action="orderOut" class="creation-form" method="post">
                <c:forEach items="${routes}" var="order">
                <div id="item${order.id}">
                    <h1>Заказ №${order.id}</h1>
                    <h2>Направление: ${order.nameRoute}</h2>
                    <h4>Номер трассы: ${order.wayId}</h4>
                    <hr>
                </div>
                </c:forEach>
            </form>
        </c:otherwise>
    </c:choose>

    <form action="orderIn" class="creation-form" method="post">


        <table>
            <tr><td>Выберете какой груз принять:</td><td>

                <select  id="order" name="in">
                    <c:forEach items="${routes}" var="i">

                        <option name="innn" class="sector-option" value="${i.id}">Груз #${i.id}</option>

                    </c:forEach>
                </select></td></tr><br>

            <tr><td colspan="2"><input type="submit" value="Далее" name="but"  id="create-input-submit"/></td></tr>
        </table>
    </form>


</div>
<a href="${pageContext.request.contextPath}/adminOrderMain" class="create-ahref-main-btn">
    <input type="submit" value="Назад"/>
</a>
</body>
</html>
