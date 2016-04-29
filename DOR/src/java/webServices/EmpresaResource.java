/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.google.gson.Gson;
import dao.EmpresaDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joaolopes
 */
@Path("empresa")
public class EmpresaResource {

    @Context
    private UriInfo context;

    public EmpresaResource() {
    }

    @GET
    @Path("/razao_social/{razaoSocial}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaRazaoSocial(@PathParam("razaoSocial") String razaoSocial) {
        boolean jaCadastrado = new EmpresaDAO().verificaRazaoSocial(razaoSocial);
        String json = new Gson().toJson(jaCadastrado);
        return Response.ok(json).build();
    }
    
    @GET
    @Path("/cnpj/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaCnpj(@PathParam("cnpj")String cnpj){
        String cnpjComMascara = aplicaMascaraCnpj(cnpj);
        boolean jaCadastrado = new EmpresaDAO().verificaCnpj(cnpjComMascara);
        String json = new Gson().toJson(jaCadastrado);
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
        System.out.println(builder.toString());
        return builder.toString();
    }
    
}
