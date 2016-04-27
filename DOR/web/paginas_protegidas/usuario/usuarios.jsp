<%-- 
    Document   : usuarios
    Created on : 26/04/2016, 12:17:03
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
        <div class="container-fluid thumbnail">
            <table class="table table-hover table-striped table-responsive col-md-9">
                <thead>
                    <th class="text-center">
                        <label>Email</label>
                    </th>
                </thead>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr class="text-center">
                        <td>${usuario.email}</td>
                        <td class="largura_5">
                            <a href="<c:url value="/controller?tarefa=PreparaEditarUsuario&usuarioEditar=${usuario.email}" context="/DOR"/>" class="btn btn-warning">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a> 
                        </td>
                        <td class="largura_5">
                            <a href="<c:url value="/controller?tarefa=PreparaRemoverUsuario&usuarioRemover=${usuario.email}" context="/DOR"/>" class="btn btn-danger">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
