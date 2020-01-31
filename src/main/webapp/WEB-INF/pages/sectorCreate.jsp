<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить сектор</title>
        <link rel="stylesheet" type="text/css"
              href="http://localhost:8080/transport_war/webres/css/style.css">
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <h1 align="center">Чтобы добавить сектор, введите следующую информацию:</h1>
        </div>
        <div id="create-div">
            <form action="sectorCreate" class="creation-form" method="post">
                    <table>
                        <tr><td>Выберете трассу:</td><td>
                            <select  id="ways" name="ways">
                                <c:forEach items="${ways}" var="i">

                                    <option name="wid" class="sector-option" value="${i.id}">${i.routeId.outset} - ${i.routeId.inset} #${i.id}</option>

                                </c:forEach>
                            </select></td></tr><br>

                        <tr><td>Задайте id(4х значное число):</td><td>      <input type="text" id="id" name="id" required/></td></tr><br>

                        <tr><td>Выберете тип транспорта:</td><td>
                            <select  id="type" name="type">

                                    <option  class="sector-option" value="самолёт">Самолёт</option>
                                    <option  class="sector-option" value="поезд">Поезд</option>
                                    <option  class="sector-option" value="автотранспорт">Автотранспорт</option>
                                    <option  class="sector-option" value="танкер">Танкер</option>

                            </select></td></tr><br>

                        <tr><td>Укажите скорость транспорта (км/ч):</td><td>      <input type="text"  name="speed" required/></td></tr><br>
                        <tr><td>Укажите стоимость использования ($) :</td><td>      <input type="text"  name="coast" required/></td></tr><br>
                        <tr><td>Укажите длительность доставки (час):</td><td>      <input type="text"  name="time" required/></td></tr><br>

                        <tr><td colspan="2"><input type="submit" value="Создать" id="create-input-submit"/></td></tr>
                    </table>  

            </form>
            
        </div>
        <a href="${pageContext.request.contextPath}/adminMain" class="create-ahref-main-btn">
                <input type="submit" value="Назад"/>
            </a>
    </body>
</html>
