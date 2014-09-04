/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.controller;

import ar.edu.utn.frsf.empleartec.gp.logica.ProyectoRN;
import ar.edu.utn.frsf.empleartec.gp.modelo.Consultoria;
import ar.edu.utn.frsf.empleartec.gp.modelo.Proyecto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author st
 */
@Named(value = "pryCtrl")
@SessionScoped
public class ProyectoController implements Serializable{
    private Consultoria proyecto;
    
    @Inject
    private ProyectoRN proyRN;
    
    @PostConstruct
    public void init(){
        proyecto = new Consultoria();
    }
    
    public String nuevo(){
        proyecto=new Consultoria();
        return null;
    }
    
    public String guardar(){
        // guardar el proyecto.
        proyRN.guardar(proyecto);
        proyecto = null;
        return null;
    }

    /**
     * @return the proyecto
     */
    public Consultoria getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Consultoria proyecto) {
        this.proyecto = proyecto;
    }
}
