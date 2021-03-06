/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
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
     *
    @Test
    public void testCadastra() {
        Cliente cliente = new Cliente();
        cliente.setNome("João Felipe Lopes de Sus");
        cliente.setCpf("089.220.379-03");
        try {
            cliente = new ClienteDAO().cadastra(cliente);
            assertEquals(1, cliente.getId());
        } catch (Exception e) {
            fail();
        }
    }*/

    /**
     * Test of buscaPorNome method, of class ClienteDAO.
     *
    @Test
    public void testBuscaPorNome() {
        Cliente clientePesquisa = new Cliente();
        clientePesquisa.setNome("j");
        for(Cliente cliente : new ClienteDAO().buscaPorNome(clientePesquisa))
            System.out.println(cliente);
    }

    @Test
    public void testCadastra() {
        System.out.println("cadastra");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.cadastra(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of buscaPorId method, of class ClienteDAO.
     *
    @Test
    public void testBuscaPorId() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        try {
            cliente = new ClienteDAO().buscaPorId(cliente);
            assertEquals("João Felipe Lopes de Sus", cliente.getNome());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test of cadastra method, of class ClienteDAO.
     *
    @Test
    public void testCadastra() {
        System.out.println("cadastra");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.cadastra(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorNome method, of class ClienteDAO.
     *
    @Test
    public void testBuscaPorNome() {
        System.out.println("buscaPorNome");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.buscaPorNome(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaProCnpjECpf method, of class ClienteDAO.
     *
    @Test
    public void testBuscaProCnpjECpf() {
        System.out.println("buscaProCnpjECpf");
        Cliente clienteBusca = null;
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.buscaProCnpjECpf(clienteBusca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of negativar method, of class ClienteDAO.
     *
    @Test
    public void testNegativar() {
        try {
            Cliente cliente = new Cliente();
            cliente.setId(1);
            new ClienteDAO().negativar(cliente);
            cliente = new ClienteDAO().buscaPorId(cliente);
            assertEquals(false, cliente.isAtivo());
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test of cadastra method, of class ClienteDAO.
     *
    @Test
    public void testCadastra() {
        System.out.println("cadastra");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.cadastra(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorNome method, of class ClienteDAO.
     *
    @Test
    public void testBuscaPorNome() {
        System.out.println("buscaPorNome");
        Cliente cliente = null;
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.buscaPorNome(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorId method, of class ClienteDAO.
     *
    @Test
    public void testBuscaPorId() {
        System.out.println("buscaPorId");
        Cliente clienteBusca = null;
        ClienteDAO instance = new ClienteDAO();
        Cliente expResult = null;
        Cliente result = instance.buscaPorId(clienteBusca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaProCnpjECpf method, of class ClienteDAO.
     *
    @Test
    public void testBuscaProCnpjECpf() {
        System.out.println("buscaProCnpjECpf");
        Cliente clienteBusca = null;
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = null;
        List<Cliente> result = instance.buscaProCnpjECpf(clienteBusca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of habilitaCliente method, of class ClienteDAO.
     *
    @Test
    public void testHabilitaCliente() {
        System.out.println("habilitaCliente");
        Cliente cliene = null;
        ClienteDAO instance = new ClienteDAO();
        instance.habilitaCliente(cliene);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of negativo method, of class ClienteDAO.
     */
    @Test
    public void testNegativo() {
        Cliente cliente = new Cliente();
        cliente.setCnpj("67.676.667/6667-67");
        assertTrue(new ClienteDAO().negativo(cliente));
    }

    /**
     * Test of habilitaCliente method, of class ClienteDAO.
     *
    @Test
    public void testHabilitaCliente() {
        System.out.println("habilitaCliente");
        Cliente cliene = null;
        ClienteDAO instance = new ClienteDAO();
        instance.habilitaCliente(cliene);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
