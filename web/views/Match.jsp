<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='style.css' %>
    </style>
    <title>FindNeigbour — Best Matches</title>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
</head>

<body>
<jsp:include page="header.jsp"/>
<main class="block small_page">
    <div class="content main__content">

        <%
            List<String> UsersContacts = (List<String>) session.getAttribute("usersContacts");

            if (UsersContacts != null && !UsersContacts.isEmpty()) {
                Iterator<String> iter = UsersContacts.iterator();
                while (iter.hasNext()) {
                    out.println("<ui>" + iter.next() + "</ui>" + "<br>");
                }
            } else out.println("<p>Нет совпадений</p>");
        %>
    </div>
</main>

<jsp:include page="footer.jsp"/>

</body>

</html>

