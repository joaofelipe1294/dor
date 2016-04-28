<%-- 
    Document   : remocao_usuario
    Created on : 26/04/2016, 23:08:58
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
        <div class="row">
            <div class="container container-fluid">
                <div class="panel panel-primary  margem_form col-md-offset-2">
                    <div class="panel-heading">
                        <label>Remover usuario</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=RemoverUsuario" context="/DOR"/>">
                            <div class ="form-group">
                                <input name="email" id="email" type ="email" class="form-control disabled" required="true" placeholder ="email" value="${usuarioRemover.email}" readonly="true" />
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="email_repetido" id="email_repetido" type="email" class="form-control" required="true" placeholder ="Repita o email"/>
                            </div>
                            <button id="botao" class="btn btn-danger" disabled="true">Remover</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/funcoes_usuario.js" context="/DOR"/>"></script>
    </body>
</html>
