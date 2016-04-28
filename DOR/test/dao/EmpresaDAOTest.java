/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelos.Empresa;
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
public class EmpresaDAOTest {
    
    public EmpresaDAOTest() {
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
     * Test of cadastra method, of class EmpresaDAO.
     */
    /*@Test
    public void testCadastra() {
        Empresa empresa = new Empresa();
        empresa.setCnpj("111111111111");
        empresa.setRazaoSocial("Apple");
        try {
            new EmpresaDAO().cadastra(empresa);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }*/
    
    /*@Test
    public void testLista(){
        for (Empresa empresa : new EmpresaDAO().lista())
            System.out.println(empresa);
    }*/
    
    /*@Test 
    public void testEditar(){
        Empresa empresa = new Empresa();
        empresa.setId(1);
        empresa.setRazaoSocial("Sun");
        empresa.setCnpj("666666666666");
        try {
            new EmpresaDAO().edita(empresa);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }*/
    
    
    @Test
    public void testeRemover(){
        Empresa empresa = new Empresa();
        empresa.setId(5);
        try {
            new EmpresaDAO().remove(empresa);
            assertTrue(true);
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }
    
}
