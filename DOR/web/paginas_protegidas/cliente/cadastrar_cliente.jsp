<%-- 
    Document   : cadastrar_cliente
    Created on : 01/05/2016, 12:19:00
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
                        <label>Cadastro de novo cliente</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=CadastrarCliente" context="/DOR"/>">
                            <div class ="form-group" id="div_razao_social">
                                <input name="nome" id="razao_social" class="form-control" required="true" placeholder ="Nome"/>
                            </div>
                            <div class="form-group">
                                <input name="tipo_cliente" id="radio_pj" type="radio" value="pessoa_juridica" checked="true"/>
                                <label for="radio_pj" style="margin-right: 5%;">Pessoa jorídica</label>
                                <input name="tipo_cliente" id="radio_pf" type="radio" value="pessoa_fisica"/>
                                <label for="radio_pf">Pessoa física</label>
                            </div>
                            <div class ="form-group margem_input" id="div_cnpj">        
                                <input name="cnpj" id="cnpj" class="form-control" placeholder ="cnpj" pattern="[1-9*./-]*" maxlength="18"/>
                            </div>
                            <div class ="form-group margem_input" id="div_cpf" hidden="true">        
                                <input name="cpf" id="cpf" class="form-control" placeholder ="cpf" pattern="[1-9*.-]*" maxlength="14"/>
                            </div>
                            <div class="form-group">
                                <label for="empresa">Empresa</label>
                                <select name="empresa" id="empresa" class="form-control">
                                    <c:forEach var="empresa" items="${empresas}">
                                        <option value="${empresa.id}"> ${empresa.razaoSocial}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button id="botao" class="btn btn-primary">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/js/funcoes_empresa.js" context="/DOR"/>"></script>
        <script>
            $('#cpf').on('keyup' , function (){
                var cpf_atual = $('#cpf').val();
                if(cpf_atual.length === 3 || cpf_atual.length === 7){
                    cpf_atual += '.';
                }else if(cpf_atual.length === 11){
                    cpf_atual += '-';
                }
                $('#cpf').val(cpf_atual);
            });
            
            
            $('#radio_pj').change(function (){
                $('#div_cnpj').toggle();
                $('#div_cpf').toggle();
            });
            
            $('#radio_pf').change(function (){
                $('#div_cnpj').toggle();
                $('#div_cpf').toggle();
            });
            
        </script>
    </body>
</html>
