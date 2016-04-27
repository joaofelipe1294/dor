/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import enums.TiposDeMensagem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joaolopes
 */
public class GerenciadoraDeMensagens {
    private TiposDeMensagem tipo;
    private String mensagem;   
    private HttpServletRequest request;

    public TiposDeMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeMensagem tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    public void adicionaMensagem(TiposDeMensagem tipo , String mensagem , HttpServletRequest request){
        HttpSession sessao = request.getSession();
        sessao.setAttribute(tipo.getValor(), mensagem);
        if(tipo == TiposDeMensagem.ERRO){
            sessao.removeAttribute(TiposDeMensagem.SUCESSO.getValor());
        }else{
            sessao.removeAttribute(TiposDeMensagem.ERRO.getValor());
        }
    }
    
}
