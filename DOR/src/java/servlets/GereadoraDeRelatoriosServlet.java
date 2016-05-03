/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import conexao.ConnectionFactory;
import dao.RegistroDAO;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Cliente;
import modelos.Registro;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author joaolopes
 */
@WebServlet(urlPatterns = "/paginas_protegidas/relatorios"  , name = "relatorios")
public class GereadoraDeRelatoriosServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()){
            String tipoRelatorio = req.getParameter("tipoRelatorio");
            String nome = "";
            Map<String , Object> params = new HashMap<>();
            if(tipoRelatorio.equals("clientesNegativos")){
                nome = req.getServletContext().getRealPath("/WEB-INF/relatorios/clientes_negativos.jasper");
                long registroId = Long.valueOf(req.getParameter("clienteId"));
                Cliente cliente = new Cliente();
                cliente.setId(registroId);
                Registro registro = new RegistroDAO().pegaEmAberto(cliente);
                params.put("COD_REGISTRO", registro.getId());
            }else if(tipoRelatorio.equals("vezesNegativo")){
                nome = req.getServletContext().getRealPath("/WEB-INF/relatorios/vezes_negativo.jasper");
                int clienteId = Integer.valueOf(req.getParameter("clienteId"));
                params.put("COD_CLIENTE", clienteId);
            }
            JasperPrint jasperPrint = JasperFillManager.fillReport(nome, params, con);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resp.getOutputStream());
            exporter.exportReport();
        } catch (Exception ex) {
            Logger.getLogger(GereadoraDeRelatoriosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
