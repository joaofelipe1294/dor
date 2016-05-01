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
import modelos.Empresa;
import modelos.Registro;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class NegativarCliente implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        Cliente cliente = (Cliente) sessao.getAttribute("clienteSelecionado");
        Empresa empresa = new Empresa();
        empresa.setId(Long.valueOf(req.getParameter("empresa")));
        Registro registro = new Registro();
        registro.setEmpresa(empresa);
        registro.setCliente(cliente);
        try {
            new ClienteDAO().negativar(cliente);
            cliente.setAtivo(false);
            new RegistroDAO().cadastrar(registro);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Cliente negativado com sucesso !");
            sessao.setAttribute("clienteSelecionado", cliente);
            return "paginas_protegidas/cliente/exibir_cliente.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao negativar cliente !");
            return "paginas_protegidas/cliente/exibir_cliente.jsp";
        }
    }
    
}
