<%-- 
    Document   : clientes
    Created on : 01/05/2016, 15:50:24
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
                        <label>Nome</label>
                    </th>
                    <th class="text-center">
                        <label>Cpf</label>
                    </th>
                    <th class="text-center">
                        <label>Cnpj</label>
                    </th>
                </thead>
                <c:forEach var="cliente" items="${clientesRetornados}">
                    <tr class="text-center">
                        <td>${cliente.nome}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.cnpj}</td>
                        <td class="largura_5">
                            <a href="<c:url value="/controller?tarefa=PreparaExibirCliente&clienteId=${cliente.id}" context="/DOR"/>" class="btn btn-info">
                                <span class="glyphicon glyphicon-search"></span>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
