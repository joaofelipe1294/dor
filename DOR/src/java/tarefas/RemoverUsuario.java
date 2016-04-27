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
public class RemoverUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String emailRepetido = req.getParameter("email_repetido");
        if(email.equals(emailRepetido)){
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            new UsuarioDAO().remove(usuario);
        }
        return "paginas_protegidas/usuario_logado.jsp";
    }
    
}
