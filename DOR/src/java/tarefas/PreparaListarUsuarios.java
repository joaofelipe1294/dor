/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.UsuarioDAO;
import interfaces.Tarefa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Usuario;

/**
 *
 * @author joaolopes
 */
public class PreparaListarUsuarios implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        List<Usuario> usuarios = new UsuarioDAO().lista();
        sessao.setAttribute("usuarios", usuarios);
        return "paginas_protegidas/usuario/usuarios.jsp";
    }
    
}
