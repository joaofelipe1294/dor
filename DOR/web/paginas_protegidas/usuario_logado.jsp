<%-- 
    Document   : usuario_logado
    Created on : 25/04/2016, 21:21:17
    Author     : joaolopes
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOR</title>
    </head>
    <body>
        
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                  <a class="navbar-brand" href="#">Brand</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="novo_usuario.jsp">Novo</a></li>
                                <li role="separator" class="divider"></li>
                            </ul>
                          </li>
                    </ul>
                </div>
            </div>
        </nav>
        <c:if test='${erro != null}'>
            <div class="alert alert-danger" role="alert" display='${erro != "null"}'>${erro}</div>
        </c:if>
        <c:if test='${sucesso != null}'>
            <div class="alert alert-success" role="alert" display='${sucesso != "null"}'>${sucesso}</div>
        </c:if>
        <script src="../js/jquery.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
