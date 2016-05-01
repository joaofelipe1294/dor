/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelos.Cliente;
import modelos.Empresa;
import modelos.Registro;
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
public class RegistroDAOTest {
    
    public RegistroDAOTest() {
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
     * Test of cadastrar method, of class RegistroDAO.
     */
    @Test
    public void testCadastrar() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        Empresa empresa = new Empresa();
        empresa.setId(12);
        Registro registro = new Registro();
        registro.setEmpresa(empresa);
        registro.setCliente(cliente);
        try {
            new RegistroDAO().cadastrar(registro);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
    
}
