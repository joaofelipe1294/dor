/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.EmpresaDAO;
import interfaces.Tarefa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Empresa;

/**
 *
 * @author joaolopes
 */
public class PreparaListarEmpresas implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        List<Empresa> listaEmpresas = new EmpresaDAO().lista();
        HttpSession sessao = req.getSession();
        sessao.setAttribute("listaEmpresas", listaEmpresas);
        return "paginas_protegidas/empresa/empresas.jsp";
    }
    
}
