/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.ClienteDAO;
import enums.TiposDeMensagem;
import interfaces.Tarefa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Cliente;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class BuscaClientePorNome implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Cliente cliente = new Cliente();
        cliente.setNome(req.getParameter("nome"));
        HttpSession sessao = req.getSession();
        try {
            List<Cliente> clientesRetornados = new ClienteDAO().buscaPorNome(cliente);
            if(clientesRetornados.size() == 1){
                sessao.setAttribute("clienteSelecionado", clientesRetornados.get(0));
                return "paginas_protegidas/cliente/exibe_cliente.jsp";
            }else if(clientesRetornados.size() > 1){
                sessao.setAttribute("clientesRetornados", clientesRetornados);
                return "paginas_protegidas/cliente/clientes.jsp";
            }else{
                new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Nenhum cliente encontrado !");
                return "paginas_protegidas/usuario_logado.jsp";
            }
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao pesquisar !");
            return "paginas_protegidas/usuario_logado.jsp";
        }
    }
    
}
