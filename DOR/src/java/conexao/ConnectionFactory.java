/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author joaolopes
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/dor" , "postgres" , "1234");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }        
    }
    
}
