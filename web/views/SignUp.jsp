
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>

<div>
    <h1>Регистрация</h1>
</div>
<div>
    <form method="post">
        <label>Логин:
            <input type="text" name="login"><br/>
        </label>

        <label>Пароль:
            <input type="text" name="password"><br/>
        </label>

        <label>Имя:
            <input type="text" name="name"><br/>
        </label>

        <label>Фамилия:
            <input type="text" name="surname"><br/>
        </label>

        <label>Пол:
            <li><input type="radio" name="sex" value="1">Женский</li>
            <li><input type="radio" name="sex" value="2">Мужской</li>
        </label>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
