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
public class PreparaEditarEmpresa implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        long idEmpresa = Long.valueOf(req.getParameter("empresaEditar"));
        Empresa empresa = new Empresa();
        empresa.setId(idEmpresa);
        try {
            empresa = new EmpresaDAO().pega(empresa);
            sessao.setAttribute("empresaSelecionada", empresa);
            return "paginas_protegidas/empresa/editar_empresa.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao selecionar empresa !");
            return "paginas_protegidas/empresa/empresas.jsp";
        }
    }
    
}
