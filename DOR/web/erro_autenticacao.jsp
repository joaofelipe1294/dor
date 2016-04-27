<%-- 
    Document   : erro_autenticacao
    Created on : 27/04/2016, 00:10:26
    Author     : joaolopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOR</title>
    </head>
    <body>
        <div class="alert alert-danger" role="alert">
            <label>Lofin e/ou senha incorreto(s)</label>
        </div>
        <div class="row">
            <div class="container container-fluid">
                <div class="panel panel-primary  margem_form col-md-offset-2">
                    <div class="panel-heading">
                        <label>Para fazer alguma operação é necessáciria a autenticação</label>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="controller?tarefa=Login">
                            <div class ="input-group">
                                <span class="input-group-addon">@</span>
                                <input name="email" type ="email" class="form-control" required="true" placeholder ="email"/>
                            </div>
                            <div class ="form-group margem_input">        
                                <input name="senha" type="password" class="form-control" required="true" placeholder ="senha"/>
                            </div>
                            <button class="btn btn-primary">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
