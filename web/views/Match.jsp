<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.User" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
</head>
<body>
<%
    List<String> UsersContacts = (List<String>) session.getAttribute("usersContacts");

    if (UsersContacts != null && !UsersContacts.isEmpty()) {
        Iterator<String> iter = UsersContacts.iterator();
        while (iter.hasNext()) {
            out.println("<ui>" + iter.next() + "</ui>" + "<br>");
        }
            } else out.println("<p>Нет совпадений</p>");
%>
</body>
</html>
