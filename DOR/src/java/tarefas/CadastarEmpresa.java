/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.EmpresaDAO;
import enums.TiposDeMensagem;
import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Empresa;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class CadastarEmpresa implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Empresa empresa = new Empresa();
        empresa.setCnpj(req.getParameter("cnpj"));
        empresa.setRazaoSocial(req.getParameter("razao_social"));
        try {
            new EmpresaDAO().cadastra(empresa);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Empresa cadastrada com sucesso !");
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao cadastrar a empresa !");
            return "paginas_protegidas/empresa/cadastrar_empresa.jsp";
        }
    }
    
}
