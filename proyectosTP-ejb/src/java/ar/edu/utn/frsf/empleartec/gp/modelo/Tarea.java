/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author st
 */
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descripcion;
    private boolean finalizada;

    //RELACIONES
    @ManyToOne
    private Proyecto proyecto;
    
    @ManyToMany(mappedBy = "tareaAsignada")
    private List<Empleado> empleadosAsignados;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the finalizada
     */
    public boolean isFinalizada() {
        return finalizada;
    }

    /**
     * @param finalizada the finalizada to set
     */
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the empleadosAsignados
     */
    public List<Empleado> getEmpleadosAsignados() {
        return empleadosAsignados;
    }

    /**
     * @param empleadosAsignados the empleadosAsignados to set
     */
    public void setEmpleadosAsignados(List<Empleado> empleadosAsignados) {
        this.empleadosAsignados = empleadosAsignados;
    }
    
    
}
