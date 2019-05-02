

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Объявление</title>
        <link rel="stylesheet" type="text/css"
              href="http://localhost:8080/kursovoi_war/webres/css/style.css">
        <script src="http://code.jquery.com/jquery-1.11.2.js"></script>
        <script src="webres/js/scripts.js" type="text/javascript"></script>
    </head>
    <body class="singleItem">
        <div>
            <h1>Name: ${items.name}</h1>
            <img src="${items.img}"/>
            <h5>About: ${items.about}</h5>
            <h5>Category: ${items.category}</h5>
            <h5><a href="${pageContext.request.contextPath}/owner?owner=${items.owner}">
            Owner: ${items.owner}</a></h5>
            <h5>Phone to buy: ${owner.phone}</h5>
            <h3>Price: ${items.price} USD</h3>
            <c:if test="${isLogin}">
                <button data-id="${items.id}"  id="addToFav" onclick="check()">
                    добавить в Избранное</button>
            </c:if>
            <hr>
        </div>

        <script>
            function check() {
                var set = new Set(); // хранит id записей
                var fav = {}; // хранит избранное пользователей


                //чтение всех данных

                if(localStorage.getItem('fav') != null){
                    fav = JSON.parse(localStorage.getItem('fav'));
                }


                var login = JSON.parse(localStorage.getItem('currentLogin'));
                var id = document.getElementById('addToFav').dataset.id;

                set = new Set(fav[login]);
                console.log(set);

                set.add(id);

                var arr = Array.from(set);
                fav[login]= arr;
                localStorage.setItem('fav', JSON.stringify(fav));

            }
        </script>



        <div>
            <form action="${pageContext.request.contextPath}/main">
                <input type="submit" value="На главную"/>
            </form>
        </div>
    </body>
</html>
