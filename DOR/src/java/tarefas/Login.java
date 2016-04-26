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
import javax.websocket.Session;
import modelos.Usuario;

/**
 *
 * @author joaolopes
 */
public class Login implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario();
        usuario.setEmail(req.getParameter("email"));
        usuario.setSenha(req.getParameter("senha"));
        boolean valido = new UsuarioDAO().verificaExistencia(usuario);
        if (valido){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario", usuario.getEmail());
            return "paginas_protegidas/usuario_logado.jsp";
        }else{
            return "index.jsp";
        }
    }
    
}
