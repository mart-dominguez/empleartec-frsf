/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.logica;

import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import javax.ejb.Local;

/**
 *
 * @author st
 */
@Local
public interface ClienteEJBLocal {
    public Cliente findById(int id);
    public void addCliente(Cliente cli);
    public void deleteCliente(Cliente cli);
}
