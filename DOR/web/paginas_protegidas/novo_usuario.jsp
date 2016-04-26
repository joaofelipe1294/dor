<%-- 
    Document   : novo_usuario
    Created on : 25/04/2016, 21:51:56
    Author     : joaolopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/index.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="row">
            <div class="container container-fluid">
                <div class="panel panel-primary  margem_form col-md-offset-2">
                    <div class="panel-heading">
                        <label>Cadastro de novo usuario</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="../controller?tarefa=CadastrarUsuario">
                            <div class ="input-group">
                                <span class="input-group-addon">@</span>
                                <input name="email" type ="email" class="form-control" required="true" placeholder ="email"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="senha" id="senha" type="password" class="form-control" required="true" placeholder ="senha"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="senha_repetida" id="repeticao" type="password" class="form-control" required="true" placeholder ="repita a senha"/>
                            </div>
                            <button id="botao" class="btn btn-primary" disabled="true">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="../js/jquery.js"></script>
        <script>
            $('#senha').on('keyup' , function (){
                var senha = $('#senha').val();
                var repeticao = $('#repeticao').val();
                if (senha === repeticao){    
                    $('#botao').prop('disabled' , false);
                    console.log("sim!")
                }else{
                    $('#botao').prop('disabled' , true);
                    console.log("nao")
                }
            });
            
            $('#repeticao').on('keyup' , function (){
                var senha = $('#senha').val();
                var repeticao = $('#repeticao').val();
                if (senha === repeticao){
                    $('#botao').prop('disabled' , false);
                    console.log("sim!")
                }else{
                    $('#botao').prop('disabled' , true);
                    console.log("nao")
                }
            });
        </script>
    </body>
</html>
