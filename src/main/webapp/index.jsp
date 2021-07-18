<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>
        <%
            out.println("Olá, Mundo!");
        %>
    </h1>

    <form action="receiveName.jsp" method="post">

        <input name="nome">
        <input name="idade">
        <button type="submit">Enviar</button>

    </form>


</body>
</html>