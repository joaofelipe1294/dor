/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.ClienteDAO;
import dao.RegistroDAO;
import enums.TiposDeMensagem;
import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Cliente;
import modelos.Registro;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class HabilitarCliente implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        Cliente cliente = (Cliente) sessao.getAttribute("clienteSelecionado");
        Registro registro = new RegistroDAO().pegaEmAberto(cliente);
        try {
            new ClienteDAO().habilitaCliente(cliente);
            new RegistroDAO().fechar(registro);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Cliente habilitado com sucesso !");
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Não foi possível habilitar o cliente");
            return "paginas_protegidas/cliente/exibir_cliente.jsp";
        }
    }
    
}
