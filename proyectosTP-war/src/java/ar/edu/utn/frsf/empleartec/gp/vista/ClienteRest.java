/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.empleartec.gp.vista;

import ar.edu.utn.frsf.empleartec.gp.logica.ClienteEJBLocal;
import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import java.io.StringReader;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author st
 */
@Path("/cliente")
@Stateless
public class ClienteRest {

    @EJB
    private ClienteEJBLocal cliEjb;

    @GET
    @Path("{idCliente}")
    public String buscarCliente(@PathParam("idCliente") String cliId) {
        Cliente unCliente = cliEjb.findById(Integer.valueOf(cliId));
        return unCliente.getNombre() + " - " + unCliente.getCorreo();
    }

    @GET
    public String buscarUnCliente() {
        Cliente unCliente = cliEjb.findById(1);
        return unCliente.getNombre() + " - " + unCliente.getCorreo();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> buscarTodos() {
        return cliEjb.listAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(String jsonData) {
        JsonReader rdr = Json.createReader(new StringReader(jsonData));
        JsonObject obj = rdr.readObject();
        Cliente cli = new Cliente();
        cli.setCorreo(obj.getString("correo"));
        cli.setId(Integer.valueOf(obj.getString("id")));
        cli.setNombre(obj.getString("nombre"));
        cliEjb.updateCliente(cli);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(@FormParam(value = "nombre") String nombre, @FormParam(value = "correo") String correo) {
        Cliente cli = new Cliente();
        cli.setCorreo(correo);
        cli.setNombre(nombre);
        cliEjb.addCliente(cli);
        return Response.ok().build();
    }

    @DELETE
    @Path("{idCliente}")
    public Response delete(@PathParam("idCliente") String cliId) {
        Cliente cli = new Cliente();
        cli.setId(Integer.valueOf(cliId));
        cliEjb.deleteCliente(cli);
        return Response.ok().build();
    }
}
