<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        .button{
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            text-decoration:none;
            text-align:center;
            padding:19px 46px;
            border:none;
            -webkit-border-radius:42px;
            -moz-border-radius:42px;
            border-radius: 42px;
            font:21px Verdana, Geneva, sans-serif;
            font-weight:bold;
            color:#ffffff;
            background-color:#43e6b8;
            background-image: -moz-linear-gradient(top, #43e6b8 0%, #1f99c2 100%);
            background-image: -webkit-linear-gradient(top, #43e6b8 0%, #1f99c2 100%);
            background-image: -o-linear-gradient(top, #43e6b8 0%, #1f99c2 100%);
            background-image: -ms-linear-gradient(top, #43e6b8 0% ,#1f99c2 100%);
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1f99c2', endColorstr='#1f99c2',GradientType=0 );
            background-image: linear-gradient(top, #43e6b8 0% ,#1f99c2 100%);
            -webkit-box-shadow:0px 10px 6px #b79ef7, inset 0px 0px 1px #ffffff;
            -moz-box-shadow: 0px 10px 6px #b79ef7,  inset 0px 0px 1px #ffffff;
            box-shadow:0px 10px 6px #b79ef7, inset 0px 0px 1px #ffffff;

            text-shadow: 0px 2px 3px #de6868;
            filter: dropshadow(color=#de6868, offx=0, offy=2); }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/main">
    <input type="submit" class="button" value="Пуск"/>
</form>
</body>
</html>
