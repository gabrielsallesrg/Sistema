package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.produtos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "realizaPedido", urlPatterns = {"/RP"})
public class realizaPedido extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession(true);
            if (session.isNew()) {
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);
                response.setHeader("Custom-newURL", URLwithID);
            }
            try {
                int idCliente = 0; //variável de teste.
                List<produtos> aut = new ArrayList<produtos>();                
                String[] checado = (request.getParameterValues("checado")); //recebe os parâmetros como string
                int[] idProdutos = new int[checado.length]; //array com o tamanho de checado[]
                int[] quantidade = new int[checado.length];
                for (int i=0; i<checado.length; i++) {
                    idProdutos[i] = Integer.parseInt(checado[i]); //recebe os valores do vetor checado convertido para inteiro
                    quantidade[i] = Integer.parseInt(request.getParameter("txtQuantidade"+idProdutos[i]));
                }
                DAO dao = new DAO();
                dao.cadastrarPedido(idProdutos, quantidade, idCliente);
                String URL = "/cliente/menucliente.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(URL);
                rd.forward(request, response); 
            }
            catch (Exception e){                
            e.printStackTrace(); //imprime no log do servidor
            e.getMessage(); //recebe a mensagem para que possa ser utilizada em alguma página.
            String urlErro = "/erroCliente.jsp";
            ServletContext sc = getServletContext(); //variável sc recebe o contexto do servlet (uma página jsp, outro servlet, uma conexão...)
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro); //redireciona o contexto para a url urlErro(string).
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