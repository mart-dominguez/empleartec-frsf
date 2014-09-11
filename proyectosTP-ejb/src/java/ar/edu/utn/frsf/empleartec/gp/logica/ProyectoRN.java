/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.logica;

import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import ar.edu.utn.frsf.empleartec.gp.modelo.Proyecto;
import ar.edu.utn.frsf.empleartec.gp.utils.EntityMng;
import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author st
 */
@Named("proyectoLogica")
@Stateless
public class ProyectoRN {

    //PersistenceContext(unitName = "pryPU")
    @Inject @EntityMng
    EntityManager em;

    public void guardar(Proyecto p){
            Cliente c1 = new Cliente();
           c1.setNombre(" ASDFHASD");
            em.persist(c1);
            System.out.println(" GUARDAR "+p);
        em.persist(p);
    }
    
    public List<Proyecto> todos(){
        return em.createQuery("SELECT p FROM Proyecto p").getResultList();
    }
}
