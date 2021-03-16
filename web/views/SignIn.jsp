<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FindNeighbour — Login</title>
    <link rel="shortcut icon" href="favicon.png" type="image/png">    <!-- Здесь есть сыылка, которую нужно переделать, солнце-->                <!-- наверное-->
    <link rel="stylesheet" href="/views/style.css">       <!-- Здесь есть сыылка, которую нужно переделать, солнце-->                 <!-- наверное-->
</head>

<body>
<header class="block page-header">

    <div class="content">

        <a href="/views/HomePage.jsp" class="logo">fn</a>      <!-- Здесь есть сыылка, которую нужно переделать, солнце-->

        <ul class="main-menu">
            <li class="main-menu__item">
                <a href="/match" class="main-menu__link">                <!-- Здесь есть сыылка, которую нужно переделать, солнце-->
                    Match
                </a>
            </li>
            <li class="main-menu__item">
                <a href="/test" class="main-menu__link">              <!-- Здесь есть сыылка, которую нужно переделать, солнце-->
                    Test
                </a>
            </li>
            <li class="main-menu__item">
                <a href="/signin" class="main-menu__link active">                <!-- Здесь есть сыылка, которую нужно переделать, солнце-->
                    SignIn
                </a>
            </li>
        </ul>

    </div>

</header>

<!--♥♥♥♥кусок выше этого коммента одинаковый на всех страницах, с точностью до того, какой из пунктов мэйн меню щас активен -->
<!-- (класс  "main-menu__link active" то есть) и тайтла в хэде, можешь копипастить переделанные ссылки♥♥♥♥♥-->

<main class = "block" >
    <div class = "content main__content">

        <h1>Найди идеального соседа</h1>
        <hr class = "fat_line">
        <form method="post">

            <p>Логин :</p>
            <input type="text" name="login"><br/>

            <p>Пароль:</p>
            <input type="password" name="password"><br/>

            <button href="/signin" class="button_link login-link">Войти</button>      <!-- Здесь есть сыылка, которую нужно переделать, солнце-->
        </form>
        <p> Еще нет аккаунта?</p>
        <a href="/signup" class="button_link signup-link">Зарегистрироваться</a>       <!-- Здесь есть сыылка, которую нужно переделать, солнце-->
    </div>

</body>
</html>