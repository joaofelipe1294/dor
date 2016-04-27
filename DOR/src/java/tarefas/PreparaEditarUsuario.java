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
public class PreparaEditarUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String emailUsuario = req.getParameter("usuarioEditar");
        Usuario usuario = new Usuario();
        usuario.setEmail(emailUsuario);
        usuario.setId(new UsuarioDAO().pegaId(usuario));
        HttpSession sessao = req.getSession();
        sessao.setAttribute("usuarioEditar", usuario);
        return "paginas_protegidas/edicao_usuario.jsp";
    }
    
}
