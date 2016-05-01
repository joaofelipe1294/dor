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
import java.sql.Statement;
import modelos.Cliente;

/**
 *
 * @author joaolopes
 */
public class ClienteDAO {
    
    public Cliente cadastra(Cliente cliente){
        String sql = "insert into cliente (nome , cpf , cnpj) values (? , ? , ?)";
        try (Connection con = new ConnectionFactory().getConnection()){
            con.setAutoCommit(false);
            try (PreparedStatement stmt = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getCnpj());
                stmt.execute();
                con.commit();
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        long clienteId = rs.getLong("cliente_id");
                        cliente.setId(clienteId);
                        return cliente;
                    }else{
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
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