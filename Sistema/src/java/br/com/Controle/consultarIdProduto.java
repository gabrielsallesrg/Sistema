package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class consultarIdProduto extends HttpServlet {

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
            int idProdutos = Integer.parseInt(request.getParameter("idProdutos"));
            if (idProdutos < 1) {
                response.sendRedirect("erroEstoque.jsp");
                idProdutos = 0;
            } //if
            else {
                DAO dao = new DAO();
                produtos p = new produtos();
                p.setIdProduto(idProdutos);
                List<produtos> listaProdutos = dao.consultaIdProduto(p);
                request.setAttribute("listaProdutos", listaProdutos);
                RequestDispatcher rd = request.getRequestDispatcher("/loja/alterarProduto.jsp");
                rd.forward(request, response);
            } //else
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
