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
public class EditarUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario();
        long usuarioId = Long.valueOf(req.getParameter("usuarioId"));
        usuario.setId(usuarioId);
        usuario.setEmail(req.getParameter("email"));
        boolean trocarSenha;
        HttpSession sessao = req.getSession();
        try {
            if (req.getParameter("trocar_senha") != null){
            usuario.setSenha(req.getParameter("senha"));
            String senhaRepetida = req.getParameter("senha_repetida");
            trocarSenha = true;
            if(!usuario.getSenha().equals(senhaRepetida)){
                throw new IllegalArgumentException();
            }
            }else{
                trocarSenha = false;
            }
            new UsuarioDAO().edita(usuario, trocarSenha);
            sessao.removeAttribute("erro");
            sessao.setAttribute("sucesso", "Usuario editado com sucesso !");
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            sessao.removeAttribute("sucesso");
            sessao.setAttribute("erro", "Erro ao editar !");
            return "paginas_protegidas/usuario_logado.jsp";
        }
    }
    
}
