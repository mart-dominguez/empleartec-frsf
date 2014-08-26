/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.vista;

import ar.edu.utn.frsf.empleartec.gp.logica.ClienteEJB;
import ar.edu.utn.frsf.empleartec.gp.logica.ClienteEJBLocal;
import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
    public String buscarCliente(@PathParam("idCliente") String cliId){
        
        Cliente unCliente = cliEjb.findById(Integer.valueOf(cliId));
        return unCliente.getNombre()+" - "+unCliente.getCorreo();
    }
     
    @GET
    public String buscarUnCliente(){
        Cliente unCliente = cliEjb.findById(1);
        return unCliente.getNombre()+" - "+unCliente.getCorreo();
    }
}
