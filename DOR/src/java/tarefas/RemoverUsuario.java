/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import dao.UsuarioDAO;
import enums.TiposDeMensagem;
import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;
import utils.GerenciadoraDeMensagens;

/**
 *
 * @author joaolopes
 */
public class RemoverUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String emailRepetido = req.getParameter("email_repetido");
        try {
            if(email.equals(emailRepetido)){
                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                new UsuarioDAO().remove(usuario);
            }
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.SUCESSO, "Usuario removido com sucesso !");
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens(req).adicionaMensagem(TiposDeMensagem.ERRO,  "Erro ao remover usuario !");
            return "paginas_protegidas/usuario/remover_usuario.jsp";
        }
    }
    
}
