<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='style.css' %>
    </style>

    <title>FindNeighbour — Login</title>

    <link rel="icon" href="http://192.168.1.105:8080/views/favicon.ico" type="image/x-icon">
</head>

<body>
<jsp:include page="header.jsp"/>

<main class="block small_page">
    <div class="content main__content">

        <h1>Find perfect neighbour</h1>
        <hr class="fat_line">
        <div class="reg_form">
            <h2> Log into your account:</h2>
            <form method="post">

                <input type="text" name="login" placeholder="Login" class="common_input"><br/>

                <input type="password" name="password" placeholder="Password" class="common_input"><br/>

                <button href="/signin" class="big_button green_button signin">Sign in</button>

            </form>
            <hr class="list_line">
            <h2>Or create new account:</h2>

            <a href="/signup" class="big_button purple_button signup">Sign up</a>
        </div>

    </div>

</main>

<jsp:include page="footer.jsp"/>

</body>

</html>