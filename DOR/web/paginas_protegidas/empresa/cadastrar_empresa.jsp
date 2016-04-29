<%-- 
    Document   : cadastrar_empresa
    Created on : 27/04/2016, 17:27:39
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
                        <label>Cadastro de nova empresa</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=CadastrarEmpresa" context="/DOR"/>">
                            <div class ="form-group" id="div_razao_social">
                                <input name="razao_social" id="razao_social" class="form-control" required="true" placeholder ="Razão social"/>
                            </div>
                            <div class ="form-group margem_input" id="div_cnpj">        
                                <input name="cnpj" id="cnpj" class="form-control" required="true" placeholder ="cnpj" pattern="[1-9*./-]*" maxlength="18" minlength="18"/>
                            </div>
                            <button id="botao" class="btn btn-primary" disabled="false">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/funcoes_empresa.js" context="/DOR"/>"></script>
        <script src="<c:url value="/js/cadastrar_empresa.js" context="/DOR"/>"></script>
    </body>
</html>
