/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import criptografia.CriptografiaMD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelos.Usuario;

/**
 *
 * @author joaolopes
 */
public class UsuarioDAO {
    
    public void cadastra(Usuario usuario){
        String sql = "INSERT INTO usuario (email , senha) VALUES (? , ?);";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, usuario.getEmail());
                String senhaCriptografada = new CriptografiaMD5().criptografa(usuario.getSenha());
                stmt.setString(2, senhaCriptografada);
                stmt.execute();
                con.commit();
            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}
