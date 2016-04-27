/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.UsuarioDAO;
import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Usuario;

/**
 *
 * @author joaolopes
 */
public class PreparaRemoverUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario();
        usuario.setEmail(req.getParameter("usuarioRemover"));
        HttpSession sessao = req.getSession();
        sessao.setAttribute("usuarioRemover", usuario);
        return "paginas_protegidas/usuario/remocao_usuario.jsp";
    }
    
}
