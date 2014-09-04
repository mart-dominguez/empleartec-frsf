/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author st
 */
@Named
@RequestScoped
public class ConexionDB {
    
    @PersistenceContext(unitName = "pryPU")
    private EntityManager em;
    
    @Produces
    @EntityMng
    public EntityManager create(){
        return em;
    }

    public void close(@Disposes @EntityMng EntityManager em){
        em.close();
    }

}
