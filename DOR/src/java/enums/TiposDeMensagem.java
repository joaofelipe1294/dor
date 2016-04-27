/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author joaolopes
 */
public enum TiposDeMensagem {
    SUCESSO ("sucesso"), 
    ERRO ("erro");
    
    private final String valor;

    private TiposDeMensagem(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
