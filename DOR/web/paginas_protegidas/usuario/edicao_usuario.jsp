<%-- 
    Document   : edicao_usuario
    Created on : 26/04/2016, 20:26:54
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
                        <label>Editar usuario</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="<c:url value="/controller?tarefa=EditarUsuario&usuarioId=${usuarioEditar.id}" context="/DOR"/>">
                            <div class ="input-group">
                                <span class="input-group-addon">@</span>
                                <input name="email" type ="email" class="form-control" required="true" placeholder ="email" value="${usuarioEditar.email}"/>
                            </div>
                            <div class="form-group margem_input">
                                    <input type="checkbox" id="trocar_senha" name="trocar_senha"> 
                                    <label for="trocar_senha">Trocar senha</label>
                            </div>
                            <div id="senhas" hidden="true">
                                <div class ="form-group margem_input">        
                                    <input name="senha" id="senha" type="password" class="form-control" placeholder ="senha"/>
                                </div>
                                <div class ="form-group margem_input">        
                                    <input name="senha_repetida" id="repeticao" type="password" class="form-control" placeholder ="repita a senha"/>
                                </div>
                            </div>
                            <button id="botao" class="btn btn-warning">Editar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $('#trocar_senha').on('click' , function (){
                var checado = document.getElementById("trocar_senha").checked;
                if(checado){
                    $('#senhas').show();
                    $('#botao').prop("disabled" , true);
                }else{
                    $('#senhas').hide();
                    $('#botao').removeProp("disabled");
                }
            });
            $('#senha').on('keyup' , function (){
                var senha = $('#senha').val();
                var repeticao = $('#repeticao').val();
                if (senha === repeticao){    
                    $('#botao').prop('disabled' , false);
                }else{
                    $('#botao').prop('disabled' , true);
                }
            });
            $('#repeticao').on('keyup' , function (){
                var senha = $('#senha').val();
                var repeticao = $('#repeticao').val();
                if (senha === repeticao){
                    $('#botao').prop('disabled' , false);
                }else{
                    $('#botao').prop('disabled' , true);
                }
            });
            </script>
                            
    </body>
</html>
