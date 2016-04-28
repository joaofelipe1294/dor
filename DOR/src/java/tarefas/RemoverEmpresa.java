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
public class RemoverEmpresa implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        try {
            Empresa empresaSelecionada = (Empresa) sessao.getAttribute("empresaSelecionada");
            String cnpjRepetido = req.getParameter("cnpj_repetido");
            if(empresaSelecionada.getCnpj().equals(cnpjRepetido)){
                new EmpresaDAO().remove(empresaSelecionada);
                new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "EMpresa removida com sucesso !");
                return "paginas_protegidas/usuario_logado.jsp";
            }else{
                new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "O cnpj informado não confere !");
                return "paginas_protegidas/empresa/remover_empresa.jsp";
            }
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao remover empresa !");
            e.printStackTrace();
            return "paginas_protegidas/empresa/remover_empresa.jsp";
        }
    }
    
}
