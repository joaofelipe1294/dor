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
public class EditarEmpresa implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        Empresa empresaSelecionada = (Empresa) sessao.getAttribute("empresaSelecionada");
        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setId(empresaSelecionada.getId());
        novaEmpresa.setCnpj(req.getParameter("cnpj"));
        novaEmpresa.setRazaoSocial(req.getParameter("razao_social"));
        try {
            new EmpresaDAO().edita(novaEmpresa);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Empresa editada com sucesso !");
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            sessao.setAttribute("empresaSelecionada", empresaSelecionada);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao editar empresa !");
            e.printStackTrace();
            return "paginas_protegidas/empresa/editar_empresa.jsp";
        }
    }
}
