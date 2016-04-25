/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelos.Usuario;
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
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
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
     * Test of cadastra method, of class UsuarioDAO.
     */
    @Test
    public void testCadastra() {
        Usuario usuario = new Usuario();
        usuario.setEmail("joaofelipe_lopes@hotmail.com");
        usuario.setSenha("1234");
        try {
            new UsuarioDAO().cadastra(usuario);
            assertTrue(true);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
        
    }
    
}
