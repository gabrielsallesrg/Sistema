/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.pedido;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Murilo RM
 */
@WebServlet(name = "consultarByCliente", urlPatterns = {"/CBC"})
public class consultarByCliente extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.isNew()) {
                    String incomingURL = request.getRequestURL().toString();
                    String URLwithID = response.encodeRedirectURL(incomingURL);
                    response.setHeader("Custom=newURL",URLwithID);                   
                } //if
            //DIFICULDADE: pegar o idCliente da sessão pelo login do usuário.
            int idCliente=0; //criado para fins de teste.
            DAO dao = new DAO();
            pedido p = new pedido();
            p.setIdCliente(idCliente);
 //           List<pedido> listaPedidos = dao.consultaByCliente(p);
//            request.setAttribute("listaPedidos", listaPedidos);
            RequestDispatcher rd = request.getRequestDispatcher("/loja/consultarByCliente.jsp");
            rd.forward(request, response);
        } //try
        catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            String urlErro = "/erroEstoque.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro);
            rd.forward(request, response);        
        } //catch        
    } //function

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
