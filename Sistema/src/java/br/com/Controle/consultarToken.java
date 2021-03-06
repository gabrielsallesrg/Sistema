package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.pedido;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class consultarToken extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.isNew()) {
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);
                response.setHeader("Custom=newURL", URLwithID);
            } //if
            String token = request.getParameter("token");

            DAO dao = new DAO();
            pedido ped = new pedido();

            ped.setToken(token);

            List<pedido> listaPedidobyToken = dao.listaPedidobyToken(ped);

            System.out.println("consultarToken.java, tamanho da listaPedidobyToken = " + listaPedidobyToken.size());
            if (listaPedidobyToken.isEmpty()) {
                RequestDispatcher dispatcher;
                ServletContext servletContext = getServletContext();
                dispatcher = servletContext.getRequestDispatcher("/erroToken.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("listaPedidobyToken", listaPedidobyToken);

                RequestDispatcher rd = request.getRequestDispatcher("/loja/entregarPedido.jsp");
                rd.forward(request, response);
            }

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
