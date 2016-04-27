/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefas;

import interfaces.Tarefa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joaolopes
 */
public class Logout implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession sessao = req.getSession();
        sessao.invalidate();
        return "index.jsp";
    }
    
}
