/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelos.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaolopes
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cadastra method, of class ClienteDAO.
     */
    @Test
    public void testCadastra() {
        Cliente cliente = new Cliente();
        cliente.setNome("João Felipe Lopes de Sus");
        cliente.setCpf("089.220.379-03");
        try {
            new ClienteDAO().cadastra(cliente);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
    
}
