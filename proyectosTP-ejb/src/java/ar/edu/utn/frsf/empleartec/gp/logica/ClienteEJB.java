/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.logica;

import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author st
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

    @PersistenceContext(unitName = "pryPU")
    private EntityManager em;
    
    public Cliente findById(int id){
        return em.find(Cliente.class, id);
    }
    
     public void addCliente(Cliente cli){
       em.persist(cli);
     }
     
       public void deleteCliente(Cliente cli){
        Cliente aux = em.find(Cliente.class, cli.getId());
        em.remove(aux);
    }
}
