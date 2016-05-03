/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.google.gson.Gson;
import dao.ClienteDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Cliente;

/**
 * REST Web Service
 *
 * @author joaolopes
 */
@Path("cliente")
public class ClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Retrieves representation of an instance of webServices.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{cpf_cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaCliente(@PathParam("cpf_cnpj") String cpfCnpj) {
        Cliente cliente = new Cliente();
        cliente.setCnpj(aplicaMascaraCnpj(cpfCnpj));
        cliente.setCpf(aplicaMascaraCpf(cpfCnpj));
        boolean estaNegativo = new ClienteDAO().negativo(cliente);
        String json = new Gson().toJson(estaNegativo);
        return Response.ok(json).build();
    }
    
    private String aplicaMascaraCnpj(String cnpj){
        StringBuilder builder = new StringBuilder("");
        for(int cont = 0 ; cont < cnpj.length() ; cont++){
            if(cont == 2 || cont == 5){
                builder.append(".");
            }else if (cont == 8){
                builder.append("/");
            }else if(cont == 12){
                builder.append("-");
            }
            builder.append(cnpj.charAt(cont));
        }
        return builder.toString();
    }
    
    private String aplicaMascaraCpf(String cpf){
        StringBuilder builder = new StringBuilder("");
        for(int cont = 0 ; cont < cpf.length() ; cont++){
            if(cont == 3 || cont == 6){
                builder.append(".");
            }else if(cont == 9){
                builder.append("-");
            }
            builder.append(cpf.charAt(cont));
        }
        return builder.toString();
    }

}
