/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author st
 */
@Entity
@DiscriminatorValue(value = "1")
public class Desarrollo extends Proyecto{

    private int horasPresupuestadas;

    /**
     * @return the horasPresupuestadas
     */
    public int getHorasPresupuestadas() {
        return horasPresupuestadas;
    }

    /**
     * @param horasPresupuestadas the horasPresupuestadas to set
     */
    public void setHorasPresupuestadas(int horasPresupuestadas) {
        this.horasPresupuestadas = horasPresupuestadas;
    }
}
