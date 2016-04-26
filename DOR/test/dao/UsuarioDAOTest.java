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
    /*@Test
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
        
    }*/
    
    /*@Test
    public void teste(){
        Usuario usuario = new Usuario();
        usuario.setEmail("joaofelipe_lopes@hotmail.com");
        usuario.setSenha("1234");
        boolean result = new UsuarioDAO().verificaExistencia(usuario);
        assertTrue(result);
        System.out.println(result);
    }*/
    
    /*@Test
    public void testaBusca(){
        Usuario usuarioBusca = new Usuario();
        usuarioBusca.setEmail("an");
        for(Usuario usuario : new UsuarioDAO().busca(usuarioBusca)){
            System.out.println(usuario);
        }
    }*/
    
    /*@Test
    public void testaLista(){
        for(Usuario usuario : new UsuarioDAO().lista())
            System.out.println(usuario);
    }*/
    
    /*@Test
    public void testeRemover(){
        try {
            Usuario usuario = new Usuario();
            usuario.setEmail("dana@white.com");
            new UsuarioDAO().remove(usuario);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }*/
    
    @Test
    public void testePegaId(){
        Usuario usuario = new Usuario();
        usuario.setEmail("anderson@siva.com");
        long id = new UsuarioDAO().pegaId(usuario);
        System.out.println(id);
    }
    
}
