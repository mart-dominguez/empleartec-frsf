/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author st
 */
@Entity
public class Empleado {
       @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
       private String nombre;
       private String rol;
       @Temporal(TemporalType.DATE)
       private Date fechaInicio;
       private double costoHora;
       private String mail;

       //RELACIONES
       @ManyToMany
       @JoinTable(name = "EMPLEADO_TAREA",
                    joinColumns = @JoinColumn(name = "ID_EMPLEADO"),
                    inverseJoinColumns = @JoinColumn(name = "ID_TAREA"))
       private List<Tarea> tareaAsignada;
       
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
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
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
     * @return the costoHora
     */
    public double getCostoHora() {
        return costoHora;
    }

    /**
     * @param costoHora the costoHora to set
     */
    public void setCostoHora(double costoHora) {
        this.costoHora = costoHora;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the tareaAsignada
     */
    public List<Tarea> getTareaAsignada() {
        return tareaAsignada;
    }

    /**
     * @param tareaAsignada the tareaAsignada to set
     */
    public void setTareaAsignada(List<Tarea> tareaAsignada) {
        this.tareaAsignada = tareaAsignada;
    }
       
       
}
