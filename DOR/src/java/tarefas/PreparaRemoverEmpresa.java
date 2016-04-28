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
import javax.servlet.http.HttpSession;
import modelos.Empresa;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class PreparaRemoverEmpresa implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Empresa empresa = new Empresa();
        empresa.setId(Long.valueOf(req.getParameter("empresaRemover")));
        try {
            empresa = new EmpresaDAO().pega(empresa);
            HttpSession sessao = req.getSession();
            sessao.setAttribute("empresaSelecionada", empresa);
            return "paginas_protegidas/empresa/remover_empresa.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao selecionar a empresa !");
            return "paginas_protegidas/empresa/empresas.jsp";
        }
        
        
    }
    
}
