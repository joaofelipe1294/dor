<%-- 
    Document   : exibe_cliente
    Created on : 01/05/2016, 15:50:32
    Author     : joaolopes
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOR</title>
    </head>
    <body>
        <c:import url="../template.jsp"/>
        <h1>Exibe cliente!</h1>
        ${clienteSelecionado.nome}
    </body>
</html>
