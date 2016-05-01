/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.ClienteDAO;
import dao.EmpresaDAO;
import enums.TiposDeMensagem;
import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Cliente;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class PreparaExibirCliente implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        long clienteId = Long.valueOf(req.getParameter("clienteId"));
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        try {
            cliente = new ClienteDAO().buscaPorId(cliente);
            HttpSession sessao = req.getSession();
            sessao.setAttribute("clienteSelecionado", cliente);
            sessao.setAttribute("empresas", new EmpresaDAO().lista());
            return "paginas_protegidas/cliente/exibir_cliente.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao encontrar cliente selecionado !");
            return "paginas_protegidas/usuario_logado.jsp";
        }
    }
    
}
