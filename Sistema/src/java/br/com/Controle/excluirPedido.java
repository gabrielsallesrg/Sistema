package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class excluirPedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true); //definindo que a sessão é verdadeira
        try {    
            if (session.isNew()) { //verificar se essa sessão já existe ou não
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);  //coloca um número de identificação na string (ID da sesão)
                response.setHeader("Custom=newURL", URLwithID); //setta o cabeçalho dos documentos de url que rodam no servidor com as novas configurações de identificação do novo usuário da nova sessão
            } //if 
            int item = Integer.parseInt(request.getParameter("excluirPedido"));
            pedido p = new pedido();
            DAO dao = new DAO();
            p.setIdPedido(item);
            dao.removerPedido(p);            
            String URL = "/cliente/ok.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(URL);
            
            request.setAttribute("operacao", "Seu pedido foi excluído com sucesso");
            rd.forward(request, response); 
        }
        catch (Exception erro) {
            erro.printStackTrace(); //imprime no log do servidor
            erro.getMessage(); //recebe a mensagem para que possa ser utilizada em alguma página.
            String urlErro = "/erroGenerico.jsp";
            ServletContext sc = getServletContext(); //variável sc recebe o contexto do servlet (uma página jsp, outro servlet, uma conexão...)
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro); //redireciona o contexto para a url urlErro(string).
            rd.forward(request, response);
        } //erro
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
