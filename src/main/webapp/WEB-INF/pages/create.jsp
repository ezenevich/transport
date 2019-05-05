<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Создать запись</title>
        <link rel="stylesheet" type="text/css"
              href="http://localhost:8080/kursovoi_war/webres/css/style.css">
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <h1 align="center">Введите следующую информацию:</h1>
        </div>
        <div id="create-div">
            <form action="create" class="creation-form" method="post">
                    <table>
                        <tr><td>Заголовок:</td><td>     <input type="text" name="name"/></td></tr><br>
                        <tr><td>Описание:</td><td>    <input type="text" name="about"/></td></tr><br>
                        <tr><td>Цена (USD):</td><td>    <input type="text" name="price"/></td></tr><br>
                        <tr><td>Фото:</td><td>      <input type="text" name="img"/></td><td>link(http://)</td></tr><br>
                        <tr><td>Маленькое фото:</td><td> <input type="text" name="smallimg"/></td><td>link(http://)</td></tr><br>
                        <tr><td>Категория:</td><td> <select name="category">
                            <option>phones</option>
                            <option>laptops</option>
                            <option>gadgets</option>
                            <option>consumer-electronics</option>
                            <option>shoes</option>
                            <option>clothing</option>
                            <option>sports-equipment</option>
                        </select></td></tr><br>
                        <tr><td colspan="2"><input type="submit" value="Создать" id="create-input-submit"/></td></tr>
                    </table>  

            </form>
            
        </div>
        <a href="${pageContext.request.contextPath}/main" class="create-ahref-main-btn">
                <input type="submit" value="На главную"/>
            </a>
    </body>
</html>
