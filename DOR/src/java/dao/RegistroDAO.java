/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Cliente;
import modelos.Registro;

/**
 *
 * @author joaolopes
 */
public class RegistroDAO {
   
    public void cadastrar(Registro registro){
        String sql = "insert into registro (empresa_id , cliente_id) values (? , ?)";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setLong(1, registro.getEmpresa().getId());
                stmt.setLong(2, registro.getCliente().getId());
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
    
    public void fechar(Registro registro){
        String sql = "update registro set data_saida = CURRENT_DATE , ativo = false where registro_id = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setLong(1, registro.getId());
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
    
    public Registro pegaEmAberto(Cliente cliente){
        String sql = "select registro_id from registro where cliente_id = ? and ativo = true;";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setLong(1, cliente.getId());
                try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        Registro registro = new Registro();
                        registro.setId(rs.getLong("registro_id"));
                        return registro;
                    }else{
                        throw new IllegalArgumentException("Registro nao encontrado !");
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
