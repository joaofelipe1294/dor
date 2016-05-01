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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Cliente> buscaPorNome(Cliente cliente){
        String sql = "select * from cliente where nome ilike(?)";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, "%" + cliente.getNome() + "%");
                try (ResultSet rs = stmt.executeQuery()){
                    List<Cliente> clientes = new ArrayList<>();
                    while(rs.next()){
                        Cliente clienteBanco = new Cliente();
                        clienteBanco.setId(rs.getLong("cliente_id"));
                        clienteBanco.setNome(rs.getString("nome"));
                        clienteBanco.setCnpj(rs.getString("cnpj"));
                        clienteBanco.setCpf(rs.getString("cpf"));
                        clientes.add(clienteBanco);
                    }
                    return clientes;
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
    
    public Cliente buscaPorId(Cliente clienteBusca){
        String sql = "select * from cliente where cliente_id = ?";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setLong(1, clienteBusca.getId());
                try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        Cliente cliente = new Cliente();
                        cliente.setId(clienteBusca.getId());
                        cliente.setNome(rs.getString("nome"));
                        cliente.setCnpj(rs.getString("cnpj"));
                        cliente.setCpf(rs.getString("cpf"));
                        return cliente;
                    }else{
                        throw new IllegalArgumentException();
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
    
    public List<Cliente> buscaProCnpjECpf(Cliente clienteBusca){
        String sql = "select * from cliente where cpf like(?) OR cnpj like(?);";
        try (Connection con = new ConnectionFactory().getConnection()){
            try (PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1, "%" + clienteBusca.getCpf() + "%");
                stmt.setString(2, "%" + clienteBusca.getCnpj() + "%");
                try (ResultSet rs = stmt.executeQuery()){
                    List<Cliente> clientes = new ArrayList<>();
                    while(rs.next()){
                        Cliente cliente = new Cliente();
                        cliente.setId(rs.getLong("cliente_id"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setCnpj(rs.getString("cnpj"));
                        cliente.setCpf(rs.getString("cpf"));
                        cliente.setAtivo(rs.getBoolean("ativo"));
                        clientes.add(cliente);
                    }
                    return clientes;
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
