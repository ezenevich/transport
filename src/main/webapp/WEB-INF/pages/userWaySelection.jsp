<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Выбрать маршрут</title>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/transport_war/webres/css/style.css">
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div>
    <h1 align="center">Направление   ${name}   включает в себя  следующие маршруты:</h1>
</div>
<div id="create-div">

    <table class="tabOrder" style="margin: auto;
                                   width: 90%;
                                   font-size: 20px;
                                   border-collapse: collapse;">
        <c:forEach items="${orderWays}" var="i">

            <tr style="border: 1px solid #00BFFF;
                                margin-top: 5px;
                                margin-bottom: 5px;
                                font-size: 25px;">
                <td colspan="2">Маршрут #${i.wayId}</td>
                <td colspan="2">Общее время доставки(часов) ${i.totalTime}</td>
                <td colspan="2">Общая стоимость($) ${i.totalCoast}</td>
            </tr>

            <c:forEach items="${i.sectors}" var="j">

                <tr>
                    <td>~</td>
                    <td>ID сектора ${j.id}</td>
                    <td>Тип ${j.type}</td>
                    <td>Время(часов) ${j.timeOnWay}</td>
                    <td>Скорость(км\ч) ${j.speed}</td>
                    <td>Стоимость($) ${j.transportCost}</td>
                </tr>

            </c:forEach>

        </c:forEach>

    </table>

    <br>
    <br>

    <form action="userWaySelection" class="creation-form" method="post">


        <table>
            <tr><td>Выберете маршрут:</td><td>

                <select  id="order" name="order">
                    <c:forEach items="${orderWays}" var="i">

                        <option name="orderId" class="sector-option" value="${i.id}">Маршрут #${i.wayId}</option>

                    </c:forEach>
                </select></td></tr><br>

            <tr><td>Укажите массу груза (max 1000кг):</td><td>      <input type="text"  name="weight" required/></td></tr><br>

            <tr><td colspan="2"><input type="submit" value="Далее" name="but2"  id="create-input-submit"/></td></tr>
        </table>
    </form>



</div>
<a href="${pageContext.request.contextPath}/main" class="create-ahref-main-btn">
    <input type="submit" value="Назад"/>
</a>
</body>
</html>
