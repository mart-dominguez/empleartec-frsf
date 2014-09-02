/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.empleartec.gp.vista;

import ar.edu.utn.frsf.empleartec.gp.logica.ClienteEJBLocal;
import ar.edu.utn.frsf.empleartec.gp.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author st
 */
@WebServlet(name = "ServletTest1", urlPatterns = {"/testCliente"})
public class ServletTest1 extends HttpServlet {

    @EJB
    private ClienteEJBLocal clienteEJB;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cliente cli1 = new Cliente();
            cli1.setNombre("Martin 1");
            cli1.setCorreo("martin@mail.com");           
            clienteEJB.addCliente(cli1);
            Cliente cli2 = new Cliente();
            cli2.setNombre("Maria 2");
            cli2.setCorreo("maria@yahoo.com");
            clienteEJB.addCliente(cli2);
            Cliente cli3 = new Cliente();
            cli3.setNombre("Laura 3");
            cli3.setCorreo("laurita@frsf.utn.edu.ar");
            clienteEJB.addCliente(cli3);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTest1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sistema Iniciado</h1>");
            out.println("<a href=\"test.html\">Ir a la pagina inicial</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
