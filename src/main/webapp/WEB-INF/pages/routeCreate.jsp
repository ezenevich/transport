<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создать маршрут</title>
        <link rel="stylesheet" type="text/css"
              href="http://localhost:8080/transport_war/webres/css/style.css">
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <h1 align="center">Для создания нового маршрута введите следующую информацию:</h1>
        </div>
        <div id="create-div">
            <form action="routeCreate" class="creation-form" method="post">
                    <table>
                        <tr><td>Пункт отправления:</td><td>     <input type="text" id="outset" name="outset" required/></td></tr><br>
                        <tr><td>Пункт прибытия:</td><td>        <input type="text" id="inset" name="inset" required/></td></tr><br>
                        <tr><td>Задайте id(4-ёх значное число):</td><td>      <input type="text" id="id" name="id" required/></td></tr><br>

                        <tr><td colspan="2"><input type="submit" value="Создать" id="create-input-submit"/></td></tr>
                    </table>  

            </form>
            
        </div>
        <a href="${pageContext.request.contextPath}/adminMain" class="create-ahref-main-btn">
                <input type="submit" value="Назад"/>
            </a>
    </body>
</html>
