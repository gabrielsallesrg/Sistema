package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class receberIdCliente extends HttpServlet {
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
            String login = request.getParameter("login");
            DAO dao = new DAO();
            login log = new login();
            log.setAccount(login);
            int idCliente = dao.getIdSessao(log); //recebe o id do cliente pelo login da sessão            
            RequestDispatcher rd = request.getRequestDispatcher("/cliente/menucliente.jsp"); //Mudar url? 
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
