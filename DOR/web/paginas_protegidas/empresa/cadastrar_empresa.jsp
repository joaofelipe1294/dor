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
        <script>
            function libera_botao(){
                var div_razao_social = $('#div_razao_social');
                var div_cnpj = $('#div_cnpj');
                console.log(div_razao_social.hasClass('has-error'));
                if(div_razao_social.hasClass('has-success') && div_cnpj.hasClass('has-success')){
                    $('#botao').prop('disabled' , false);
                }else{
                    $('#botao').prop('disabled' , true);
                }
            }
            
            $('#razao_social').on('blur' , function (){
                var razao_social = $('#razao_social').val();
                $.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "http://localhost:8084/DOR/webresources/empresa/razao_social/" + razao_social ,
                    success: function (data, textStatus, jqXHR) {
                        if(data === true){
                            $('#div_razao_social').addClass('has-error');
                            $('#div_razao_social').removeClass('has-success');
                        }else{
                            $('#div_razao_social').removeClass('has-error');
                            $('#div_razao_social').addClass('has-success');
                        }
                        libera_botao();
                    }
                });
            });
            
            function remove_mascara (mascara){
                var contador = 0;
                var cnpj = '';
                while(contador < mascara.length){
                    if(mascara[contador] !== '.' && mascara[contador] !== '/' && mascara[contador] !== '-'){
                        cnpj += mascara[contador];
                    }
                    contador++;
                }
                return cnpj;
            }
            
            $('#cnpj').on('blur' , function (){
                var cnpj = remove_mascara($('#cnpj').val());
                $.ajax({
                    type: 'GET' , 
                    dataType: 'json' , 
                    url: "http://localhost:8084/DOR/webresources/empresa/cnpj/" + cnpj ,
                    success: function (data, textStatus, jqXHR) {
                        if(data === true){
                            $('#div_cnpj').addClass('has-error');
                            $('#div_cnpj').removeClass('has-success');
                        }else{
                            $('#div_cnpj').removeClass('has-error');
                            $('#div_cnpj').addClass('has-success'); 
                        }
                        libera_botao();
                    }
                });
            });
        </script>
    </body>
</html>
