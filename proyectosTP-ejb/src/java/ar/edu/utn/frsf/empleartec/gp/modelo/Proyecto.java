/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author st
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PROYECTO",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFinEstimada;
    @Temporal(TemporalType.DATE)
    private Date fechaFinReal;

    // RELACIONES
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFinEstimada
     */
    public Date getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    /**
     * @param fechaFinEstimada the fechaFinEstimada to set
     */
    public void setFechaFinEstimada(Date fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    /**
     * @return the fechaFinReal
     */
    public Date getFechaFinReal() {
        return fechaFinReal;
    }

    /**
     * @param fechaFinReal the fechaFinReal to set
     */
    public void setFechaFinReal(Date fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the tareas
     */
    public List<Tarea> getTareas() {
        return tareas;
    }

    /**
     * @param tareas the tareas to set
     */
    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    
}
