<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>FindNeighbour — SignUp</title>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
</head>

<body>

<jsp:include page="header.jsp"/>

<main class="block small_page">
    <div class="content main__content">
        <h1>Create new account</h1>

        <hr class="fat_line">
        <div class="reg_form">
            <form method="post" class="signup_form">

                <div class="horiz">

                    <input type="text" name="login" placeholder="Login" class="common_input login">

                    <input type="text" name="password" placeholder="Password" class="common_input password">

                </div>


                <div class="cl horiz">

                    <input type="text" name="name" placeholder="First Name" class="common_input name">

                    <input type="text" name="surname" placeholder="Surname" class="common_input surname">

                </div>


                <div class="cl question_block">
                    <ul class="horiz1">
                        <p class="horiz_par horiz1"> Пол: </p>
                        <li class="horiz1">
                            <input id="w" type="radio" name="sex" value="1" class="rad1">
                            <label class="question-label tight-label" for="w"> Женский </label>
                        </li>

                        <li class="horiz1">
                            <input id="m" type="radio" name="sex" value="2" class="rad2">
                            <label class="question-label tight-label" for="m"> Мужской</label>
                        </li>
                    </ul>
                </div>

                <br class="cl"/>

                <input type="text" name="ph_number" placeholder="Phone Number" class="common_input wide phone">

                <br class="cl"/>

                <button type="submit" class="large_button Submit">Submit</button>

            </form>
        </div>
    </div>

    <script type="text/javascript">
        <%@include file="script2.js"%>
    </script>

</main>

<jsp:include page="footer.jsp"/>

</body>

</html>