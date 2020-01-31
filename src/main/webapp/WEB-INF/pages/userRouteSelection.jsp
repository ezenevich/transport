<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Выбрать направление</title>
    <link rel="stylesheet" type="text/css"
          href="http://localhost:8080/transport_war/webres/css/style.css">
    <script src="webres/js/scripts.js" type="text/javascript"></script>
</head>
<body>
<div>
    <h1 align="center">Для начала следует выбрать направление:</h1>
</div>
<div id="create-div">

    <c:choose>
        <c:when test="${empty routes}">
            <span class="spanText">Упс... Что-то пошло не так, напишите в службу поддержки!</span>
        </c:when>

        <c:otherwise>
            <form action="userRouteSelection" class="creation-form" method="post">
                <table>
                    <tr><td>Маршрут:</td><td>

                        <select  id="route" name="route">
                            <c:forEach items="${routes}" var="i">

                                <option name="rid" value="${i.id}">${i.outset} - ${i.inset}</option>

                            </c:forEach>


                        </select></td></tr><br>



                    <tr><td colspan="2"><input type="submit" value="Далее" name="but"  id="create-input-submit"/></td></tr>
                </table>
            </form>
        </c:otherwise>
    </c:choose>


</div>
<a href="${pageContext.request.contextPath}/main" class="create-ahref-main-btn">
    <input type="submit" value="Назад"/>
</a>
</body>
</html>
