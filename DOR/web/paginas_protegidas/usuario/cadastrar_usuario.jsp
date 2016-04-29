<%-- 
    Document   : novo_usuario
    Created on : 25/04/2016, 21:51:56
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
                        <label>Cadastro de novo usuario</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=CadastrarUsuario" context="/DOR"/>">
                            <div class ="input-group" id="div_email">
                                <span class="input-group-addon">@</span>
                                <input id="email" name="email" type ="email" class="form-control" required="true" placeholder ="email"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="senha" id="senha" type="password" class="form-control" required="true" placeholder ="senha"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="senha_repetida" id="senha_repetida" type="password" class="form-control" required="true" placeholder ="repita a senha"/>
                            </div>
                            <button id="botao" class="btn btn-primary" disabled="true">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/funcoes_usuario.js" context="/DOR"/>"></script>
    </body>
</html>
