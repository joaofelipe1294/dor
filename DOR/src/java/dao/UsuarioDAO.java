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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Usuario> busca(Usuario usuario){
        String sql = "select email\n" +
                     "from usuario\n" +
                     "where email like ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, "%" + usuario.getEmail() + "%");
                try (ResultSet rs = stmt.executeQuery()){
                    List<Usuario> usuarios = new ArrayList<>();
                    while(rs.next()){
                        Usuario usuarioEncontrado = new Usuario();
                        usuarioEncontrado.setEmail(rs.getString("email"));
                        usuarios.add(usuarioEncontrado);
                    }
                    return usuarios;
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
    
    public List<Usuario> lista(){
        String sql = "select email\n" +
                     "from usuario";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                try (ResultSet rs = stmt.executeQuery()){
                    List<Usuario> usuarios = new ArrayList<>();
                    while(rs.next()){
                        Usuario usuario = new Usuario();
                        usuario.setEmail(rs.getString("email"));
                        usuarios.add(usuario);
                    }
                    return usuarios;
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
    
    public void remove(Usuario usuario){
        String sql = "delete from usuario\n" +
                     "where email = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, usuario.getEmail());
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
    
    public long pegaId(Usuario usuario){
        String sql = "select usuario_id from usuario where email = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, usuario.getEmail());
                try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        long usuarioId = rs.getLong("usuario_id");
                        return usuarioId;
                    }
                    throw new IllegalArgumentException("Email informado nao esta cadastrado");
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
    
    public void edita(Usuario usuario , boolean trocarSenha){
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            if (trocarSenha){
                trocaEmailESenha(usuario , con);
            }else{
                trocaApenasEmail(usuario , con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void trocaEmailESenha(Usuario usuario , Connection con) throws SQLException{
        String sql = "update usuario set email = ? , senha = ? where usuario_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, usuario.getEmail());
            String senhaCriptografada = new CriptografiaMD5().criptografa(usuario.getSenha());
            stmt.setString(2, senhaCriptografada);
            stmt.setLong(3, usuario.getId());
            stmt.execute();
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    private void trocaApenasEmail(Usuario usuario , Connection con) throws SQLException{
        String sql = "update usuario set email = ? where usuario_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, usuario.getEmail());
            stmt.setLong(2, usuario.getId());
            stmt.execute();
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new RuntimeException();
        }
    }   
    
    public boolean verificaEmail(String email){
        String sql = "select count(1) as \"aparicoes\"\n" +
                     "from usuario\n" +
                     "where email = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, email);
                try (ResultSet rs = stmt.executeQuery()){
                    int numeroAparicoes = 0;
                    if(rs.next()){
                        numeroAparicoes = rs.getInt("aparicoes");
                    }
                    if (numeroAparicoes > 0){
                        return true;
                    }else{
                        return false;
                    }
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
