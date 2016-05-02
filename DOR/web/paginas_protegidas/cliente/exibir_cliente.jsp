<%-- 
    Document   : exibe_cliente
    Created on : 01/05/2016, 15:50:32
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
                        <div class ="form-group" id="div_razao_social">
                            <input name="nome" id="razao_social" class="form-control" required="true" placeholder ="Nome" value="${clienteSelecionado.nome}" disabled="true"/>
                        </div>
                        <c:if test="${clienteSelecionado.cnpj != null}">
                            <div class ="form-group margem_input" id="div_cnpj">        
                                <input name="cnpj" id="cnpj" class="form-control" placeholder ="cnpj" pattern="[0-9*./-]*" maxlength="18" value="${clienteSelecionado.cnpj}" disabled="true"/>
                            </div>
                        </c:if>
                        <c:if test="${clienteSelecionado.cpf != null}">
                            <div class ="form-group margem_input" id="div_cpf">        
                                <input name="cpf" id="cpf" class="form-control" placeholder ="cpf" pattern="[0-9*.-]*" maxlength="14" value="${clienteSelecionado.cpf}" disabled="true"/>
                            </div>
                        </c:if>
                        <c:if test="${clienteSelecionado.ativo == true}">
                            <div class="alert alert-danger" role="alert">Cliente Negativo </div>
                            <form method="post" action="<c:url value="/controller?tarefa=HabilitarCliente" context="/DOR"/>">
                                <button class="btn btn-success">Habilitar cliente</button>
                            </form>
                        </c:if>
                        <c:if test="${clienteSelecionado.ativo == false}">
                            <div class="alert alert-success" role="alert">Cliente ok</div>
                            <form method="post" action="<c:url value="/controller?tarefa=NegativarCliente" context="/DOR"/>">
                                <div class="form-group">
                                    <select class="form-control" name="empresa">
                                        <c:forEach items="${empresas}" var="empresa">
                                            <option value="${empresa.id}">${empresa.razaoSocial}</option>
                                        </c:forEach>
                                    </select>
                                </div>                                
                                <button class="btn btn-danger">Negativar</button>
                            </form>
                            
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
