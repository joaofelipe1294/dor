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
import modelos.Usuario;

/**
 *
 * @author joaolopes
 */
public class CadastrarUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario();
        usuario.setEmail(req.getParameter("email"));
        usuario.setSenha(req.getParameter("senha"));
        String senhaRepetida = req.getParameter("senha_repetida");
        if(usuario.getSenha().equals(senhaRepetida)){
            new UsuarioDAO().cadastra(usuario);
            return "paginas_protegidas/usuario_logado.jsp";
        }
        
        return "paginas_protegidas/usuario_logado.jsp";
    }
}
