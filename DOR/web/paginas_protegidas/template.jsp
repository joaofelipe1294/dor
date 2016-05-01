<%-- 
    Document   : template
    Created on : 26/04/2016, 19:35:45
    Author     : joaolopes
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css" context="/DOR"/>">
        <link rel="stylesheet" href="<c:url value="/css/index.css" context="/DOR"/>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DOR</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<c:url value="/paginas_protegidas/usuario_logado.jsp" context="/DOR"/>">DOR</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value="/paginas_protegidas/usuario/cadastrar_usuario.jsp" context="/DOR"/>">Novo</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="<c:url value="/controller?tarefa=PreparaListarUsuarios" context="/DOR"/>">Lista</a></li>
                            </ul>
                        </li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Empresa<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value="/paginas_protegidas/empresa/cadastrar_empresa.jsp" context="/DOR"/>">Nova</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="<c:url value="/controller?tarefa=PreparaListarEmpresas" context="/DOR"/>">Lista</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cliente<span class="caret"></span></a>
                            <ul class="dropdown-menu" style="width: 300px;">
                                <li><a href="<c:url value="/controller?tarefa=PreparaCadastrarCliente" context="/DOR"/>">Novo</a></li>
                                <li role="separator" class="divider"></li>
                                <li>
                                    <form method="post" class="navbar-form navbar-left" role="search" action="<c:url value="/controller?tarefa=BuscaClientePorNome" context="/DOR"/>">
                                        <div class="form-group">
                                            <input name="nome" class="form-control" placeholder="nome">
                                        </div>
                                        <button class="btn btn-default">Pesquisar</button>
                                    </form>
                                </li>
                                <li role="separator" class="divider"></li>
                                <li>
                                    <form method="post" class="navbar-form navbar-left" role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="cpf/cnpj">
                                        </div>
                                        <button type="submit" class="btn btn-default">Pesquisar</button>
                                    </form>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="text-center">                            
                            <a href="<c:url value="/controller?tarefa=PreparaEditarUsuario&usuarioEditar=${usuario}" context="/DOR"/>">
                                <span class="glyphicon glyphicon-user"></span>  ${usuario}
                            </a>
                        </li>
                        <li class="active"><a href="<c:url value="/controller?tarefa=Logout" context="/DOR"/>">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <c:if test='${erro != null}'>
            <div class="alert alert-danger" role="alert" display='${erro != "null"}'>${erro}</div>
        </c:if>
        <c:if test='${sucesso != null}'>
            <div class="alert alert-success" role="alert" display='${sucesso != "null"}'>${sucesso}</div>
        </c:if>
        <script src="<c:url value="/js/jquery.js" context="/DOR"/>"></script>
        <script src="<c:url value="/bootstrap/js/bootstrap.min.js" context="/DOR"/>"></script>
    </body>
</html>
