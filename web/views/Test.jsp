<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='style.css' %>
    </style>

    <title> FindNeighbour — Test </title>
    <link rel="shortcut icon" href="favicon.ico" type="image/png">
</head>

<body>
<jsp:include page="header.jsp"/>
<main class="block">
    <div class="content main__content">

        <h1>Тест</h1>
        <hr class="fat_line">

        <h2 class="accent"> Пожалуйста, заполните данную анкету. Благодаря указанной в ней информации мы сможем найти
            для Вас лучших соседей.</h2>


        <form action="" method="post" class="test_form">
            <ol class="main_list">

                <hr class="list_line">

                <li>
                    <p class="list-heading">Ваш курс обучения : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="11" type="radio" name="ans1" value="1" class="r11">
                            <label class="question-label" for="11">1</label>
                        </li>
                        <li class="question-item">
                            <input id="12" type="radio" name="ans1" value="2" class="r12">
                            <label class="question-label" for="12">2</label>
                        </li>
                        <li class="question-item">
                            <input id="13" type="radio" name="ans1" value="3" class="r13">
                            <label class="question-label" for="13">3</label>
                        </li>
                        <li class="question-item">
                            <input id="14" type="radio" name="ans1" value="4" class="r14">
                            <label class="question-label" for="14">4</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Соседа с какого курсы Bы бы хотели : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="21" type="radio" name="ans2" value="1" class="r21">
                            <label class="question-label" for="21">1</label>
                        </li>
                        <li class="question-item">
                            <input id="22" type="radio" name="ans2" value="2" class="r22">
                            <label class="question-label" for="22">2</label>
                        </li>
                        <li class="question-item">
                            <input id="23" type="radio" name="ans2" value="3" class="r23">
                            <label class="question-label" for="23">3</label>
                        </li>
                        <li class="question-item">
                            <input id="24" type="radio" name="ans2" value="4" class="r24">
                            <label class="question-label" for="24">4</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Предпочитаемый этаж : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="31" type="radio" name="ans3" value="1" class="r31">
                            <label class="question-label" for="31">1</label>
                        </li>
                        <li class="question-item">
                            <input id="32" type="radio" name="ans3" value="2" class="r32">
                            <label class="question-label" for="32">2</label>
                        </li>
                        <li class="question-item">
                            <input id="33" type="radio" name="ans3" value="3" class="r33">
                            <label class="question-label" for="33">3</label>
                        </li>
                        <li class="question-item">
                            <input id="34" type="radio" name="ans3" value="4" class="r34">
                            <label class="question-label" for="34">4</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Режим дня : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="41" type="radio" name="ans4" value="1" class="r41">
                            <label class="question-label" for="41">Жаворонок</label>
                        </li>
                        <li class="question-item">
                            <input id="42" type="radio" name="ans4" value="2" class="r42">
                            <label class="question-label" for="42">Сова</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Отношение к гостям в комнате : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="51" type="radio" name="ans5" value="1" class="r51">
                            <label class="question-label" for="51">Негативное</label>
                        </li>
                        <li class="question-item">
                            <input id="52" type="radio" name="ans5" value="3" class="r52">
                            <label class="question-label" for="52">Нейтральное</label>
                        </li>
                        <li class="question-item">
                            <input id="53" type="radio" name="ans5" value="2" class="r53">
                            <label class="question-label" for="53">Положительное</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Отношение к учебе : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="61" type="radio" name="ans6" value="1" class="r61">
                            <label class="question-label" for="61">Постоянно учусь</label>
                        </li>
                        <li class="question-item">
                            <input id="62" type="radio" name="ans6" value="2" class="r62">
                            <label class="question-label" for="62">Учусь много, но не постоянно</label>
                        </li>
                        <li class="question-item">
                            <input id="63" type="radio" name="ans6" value="3" class="r63">
                            <label class="question-label" for="63">Учусь минимально</label>
                        </li>
                    </ul>
                </li>

                <hr class="list_line">

                <li>
                    <p class="list-heading"> Отношение к курению : </p>

                    <ul class="question-list">
                        <li class="question-item">
                            <input id="71" type="radio" name="ans7" value="1" class="r71">
                            <label class="question-label" for="71">Негативное</label>
                        </li>
                        <li class="question-item">
                            <input id="72" type="radio" name="ans7" value="2" class="r72">
                            <label class="question-label" for="72">Нейтральное</label>
                        </li>
                        <li class="question-item">
                            <input id="73" type="radio" name="ans7" value="3" class="r73">
                            <label class="question-label" for="73">Положительное</label>
                        </li>
                    </ul>

                </li>

                <hr class="list_line">

            </ol>
            <button type="submit" class="large_button">submit</button>

        </form>
    </div>

    <script type="text/javascript">
        <%@include file="script1.js"%>
    </script>

</main>

<jsp:include page="footer.jsp"/>

</body>

</html>