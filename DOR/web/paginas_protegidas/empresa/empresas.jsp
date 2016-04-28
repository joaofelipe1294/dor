<%-- 
    Document   : empresas
    Created on : 27/04/2016, 23:41:11
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
                        <label>Razão social</label>
                    </th>
                    <th class="text-center">
                        <label>CNPJ</label>
                    </th>
                </thead>
                <c:forEach var="empresa" items="${listaEmpresas}">
                    <tr class="text-center">
                        <td>${empresa.razaoSocial}</td>
                        <td>${empresa.cnpj}</td>
                        <td class="largura_5">
                            <a href="<c:url value="/controller?tarefa=PreparaEditarEmpresa&empresaEditar=${empresa.id}" context="/DOR"/>" class="btn btn-warning">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a> 
                        </td>
                        <td class="largura_5">
                            <a href="<c:url value="/controller?tarefa=PreparaRemoverEmpresa&empresaRemover=${empresa.id}" context="/DOR"/>" class="btn btn-danger">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a> 
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
