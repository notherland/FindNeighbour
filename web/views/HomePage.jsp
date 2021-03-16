<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 05.03.2021
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>

<p>Логин: ${login}</p>
<p>Имя: ${name}</p>
<p>Фамилия: ${surname}</p>

<div>
    <button onclick="location.href='/test' ">Пройти тест</button>
</div>
<div>
    <button onclick="location.href='/match'">Показать наиболее подходящих соседей</button>
</div>

</body>
</html>
