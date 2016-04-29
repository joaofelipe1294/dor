/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joaolopes
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of webServices.UsuarioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{email}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("email") String email) {
        boolean jaCadastrado = new UsuarioDAO().verificaEmail(email);
        String json = new Gson().toJson(jaCadastrado);
        return Response.ok(json).build();
    }

    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
