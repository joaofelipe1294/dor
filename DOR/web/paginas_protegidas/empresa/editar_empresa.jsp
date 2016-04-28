<%-- 
    Document   : editar_empresa
    Created on : 28/04/2016, 00:09:06
    Author     : joaolopes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="../template.jsp"/>
        <div class="row">
            <div class="container container-fluid">
                <div class="panel panel-primary  margem_form col-md-offset-2">
                    <div class="panel-heading">
                        <label>Edição de empresa</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=CadastrarEmpresa" context="/DOR"/>">
                            <div class ="form-group">
                                <input name="razao_social" class="form-control" required="true" placeholder ="Razão social" value="${empresaSelecionada.razaoSocial}"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="cnpj" id="cnpj" class="form-control" required="true" placeholder ="cnpj" pattern="[1-9*./-]*" maxlength="18" minlength="18" value="${empresaSelecionada.cnpj}"/>
                            </div>
                            <button id="botao" class="btn btn-primary">Editar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $('#cnpj').on('keyup' , function (){
                var cnpj = $('#cnpj').val();
                var campo_cnpj = $('#cnpj');
                if(cnpj.length === 2 || cnpj.length === 6){
                    campo_cnpj.val(cnpj += '.');
                }else if (cnpj.length === 10){
                    campo_cnpj.val(cnpj += '/')
                }else if (cnpj.length === 15){
                    campo_cnpj.val(cnpj += '-');
                }
            });
        </script>
    </body>
</html>
