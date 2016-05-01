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
public class BuscaClienteProCpfCnpj implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String entrada = req.getParameter("cpf_cnpj");
        String cnpj = aplicaMascaraCnpj(entrada);
        String cpf = aplicaMascaraCpf(entrada);
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setCnpj(cnpj);
        HttpSession sessao = req.getSession();
        try {
            List<Cliente> clientes = new ClienteDAO().buscaProCnpjECpf(cliente);
            if(clientes.size() == 1){
                sessao.setAttribute("empresas", new EmpresaDAO().lista());
                sessao.setAttribute("clienteSelecionado", clientes.get(0));
                return "paginas_protegidas/cliente/exibir_cliente.jsp";
            }else if(clientes.size() > 1){
                sessao.setAttribute("clientesRetornados", clientes);
                return "paginas_protegidas/cliente/clientes.jsp";
            }else{
                new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Nenhum resultado encontrado !");
                return "paginas_protegidas/usuario_logado.jsp";
            }
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao buscar cliente !");
            return "paginas_protegidas/usuario_logado.jsp";
        }
    }
    
    
    private String aplicaMascaraCnpj(String cnpj){
        StringBuilder builder = new StringBuilder("");
        for(int cont = 0 ; cont < cnpj.length() ; cont++){
            if(cont == 2 || cont == 5){
                builder.append(".");
            }else if (cont == 8){
                builder.append("/");
            }else if(cont == 12){
                builder.append("-");
            }
            builder.append(cnpj.charAt(cont));
        }
        return builder.toString();
    }
    
    private String aplicaMascaraCpf(String cpf){
        StringBuilder builder = new StringBuilder("");
        for(int cont = 0 ; cont < cpf.length() ; cont++){
            if(cont == 3 || cont == 6){
                builder.append(".");
            }else if(cont == 9){
                builder.append("-");
            }
            builder.append(cpf.charAt(cont));
        }
        return builder.toString();
    }
}
