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
import java.sql.ResultSet;
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
    
    public boolean verificaExistencia(Usuario usuario){
        String sql = "select senha	\n" +
                     "from usuario\n" +
                     "where email = ?;";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, usuario.getEmail());
                try (ResultSet rs = stmt.executeQuery()){
                    if (rs.next()){
                        Usuario usuarioBanco = new Usuario();
                        usuarioBanco.setSenha(rs.getString("senha"));
                        String senhaCriptografada = new CriptografiaMD5().criptografa(usuario.getSenha());
                        if(usuarioBanco.getSenha().equals(senhaCriptografada)){
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
}