<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entities.User" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 08.03.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
</head>
<body>
<%
    List<String> UsersContacts = (List<String>) session.getAttribute("usersContacts");

    if (UsersContacts != null && !UsersContacts.isEmpty()) {
        out.println("<ui>");
        Iterator<String> iter = UsersContacts.iterator();
        while (iter.hasNext()) {
            out.println(iter.next());
        }
        out.println("</ui>");
    } else out.println("<p>Нет совпадений</p>");
%>
</body>
</html>
