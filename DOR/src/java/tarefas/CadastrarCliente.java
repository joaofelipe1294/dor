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
import modelos.Cliente;
import modelos.Empresa;
import modelos.Registro;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class CadastrarCliente implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Cliente cliente = new Cliente();
        cliente.setNome(req.getParameter("nome"));
        String tipoCliente = req.getParameter("tipo_cliente");
        if(tipoCliente.equals("pessoa_juridica")){
            cliente.setCnpj(req.getParameter("cnpj"));
        }else if (tipoCliente.equals("pessoa_fisica")){
            cliente.setCpf(req.getParameter("cpf"));
        }
        Empresa empresa = new Empresa();
        empresa.setId(Long.valueOf(req.getParameter("empresa")));
        
        try {
            cliente = new ClienteDAO().cadastra(cliente);
            Registro registro = new Registro();
            registro.setCliente(cliente);
            registro.setEmpresa(empresa);
            new RegistroDAO().cadastrar(registro);
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Cliente registrado com sucesso !");
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao cadastrar cliente !");
        }
        return "paginas_protegidas/cliente/cadastrar_cliente.jsp";
    }
    
}
