/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.Tarefa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joaolopes
 */
@WebServlet(urlPatterns = "/controller"  , name = "controller")
public class Controller extends HttpServlet{
    
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        String tarefa = req.getParameter("tarefa");
        if(tarefa == null){
            throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
        }
        tarefa = "modelos." + tarefa;
        try {
            Class<?> tipo = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) tipo.newInstance();
            String pagina = instancia.executa(req , resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
    
}
