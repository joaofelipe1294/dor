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
public class EditarUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario usuario = new Usuario();
        long usuarioId = Long.valueOf(req.getParameter("usuarioId"));
        usuario.setId(usuarioId);
        usuario.setEmail(req.getParameter("email"));
        boolean trocarSenha;
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
            new GerenciadoraDeMensagens().adicionaMensagem(TiposDeMensagem.SUCESSO, "Usuario editado com sucesso !", req);
            return "paginas_protegidas/usuario_logado.jsp";
        } catch (Exception e) {
            new GerenciadoraDeMensagens().adicionaMensagem(TiposDeMensagem.ERRO, "Erro ao editar !", req);
            return "paginas_protegidas/usuario_logado.jsp";
        }
    }
    
}
