<%--
  Created by IntelliJ IDEA.
  User: Pablo Junior
  Date: 17/07/2021
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name = request.getParameter("nome");
        String idade = request.getParameter("idade");
        out.println("Nome: " + name);
        out.println("Idade: " + idade);

    %>
</body>
</html>
