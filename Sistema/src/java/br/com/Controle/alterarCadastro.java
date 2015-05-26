package br.com.Controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class alterarCadastro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            try{
                
             String pNome = request.getParameter("nome"); //obrigatório
            String sNome = request.getParameter("sobrenome"); //obrigatório
            String endereco = request.getParameter("endereco"); 
            String telefone = request.getParameter("telefone"); //obrigatório
            String cidade = request.getParameter("cidade"); //obrigatório
            String tipo = request.getParameter("tipo");
            String email = request.getParameter("email");            
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            
            
            System.out.println(pNome);
            System.out.println(email);
            
                String urlOK = "/ok.jsp";
                ServletContext sc = getServletContext();
                
                request.setAttribute("operacao", "Foi alterado o login/senha. Verifique");
                
                RequestDispatcher rd = sc.getRequestDispatcher(urlOK);                
                rd.forward(request, response);
                
                
            }catch(Exception e){
                            e.printStackTrace();
            e.getMessage();
            System.out.println("consultarToken.java, catch");
            String urlErro = "/erroEstoque.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro);
            rd.forward(request, response);  
            }
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
