<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        <%@include file='style.css' %>
    </style>
    <title>HomePage</title>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
</head>

<body>
<jsp:include page="header.jsp"/>

<main class="block small_page">
    <div class="content main__content">
        <h1> Your profile </h1>
        <hr class="fat_line">
        <div class="accent">
            <p>Login: ${login}</p>
            <p>Name: ${name}</p>
            <p>Surname: ${surname}</p>
        </div>

    </div>

</main>

<jsp:include page="footer.jsp"/>

</body>

</html>