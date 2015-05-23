package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.produtos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class alterarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.isNew()) { //verificar se essa sessão já existe ou não
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);  //coloca um número de identificação na string (ID da sesão)
                response.setHeader("Custom=newURL", URLwithID); //setta o cabeçalho dos documentos de url que rodam no servidor com as novas configurações de identificação do novo usuário da nova sessão
            } //if
            
            int idProdutos = Integer.parseInt(request.getParameter("idProdutos"));
            String descricao = request.getParameter("descricao");
            double valor = Double.parseDouble(request.getParameter("valor"));
            int estoque = Integer.parseInt(request.getParameter("estoque"));
 
            String situacao_aux = request.getParameter("situacao");
            char situacao = situacao_aux.charAt(0);
            if (descricao.isEmpty() || descricao == null) {
                descricao = "";
                response.sendRedirect("/erroAlterar.jsp");
            }
            else if (valor < 0) {
                valor = 0d;
                response.sendRedirect("/erroAlterar.jsp");
            }
            else if (estoque < 0) {
                estoque = 0;
                response.sendRedirect("/erroAlterar.jsp");
            }
            else if (situacao != '1' && situacao != '0') {
                situacao = ' ';
                response.sendRedirect("/erroAlterar.jsp");
            }
            else {
                
                situacao = '0';
                
                produtos Produto = new produtos(idProdutos, estoque, valor, descricao, situacao);
                DAO dao = new DAO();
                dao.alteraProduto(Produto);
                request.setAttribute("listaProdutos", dao); //NOME DA ARRAYLIST. LEMBRAR DE FAZER USO DO MESMO NOME NO JSP!
                String urlOK = "/loja/alteracaoRealizada.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(urlOK);
                rd.forward(request, response);
                descricao = "";
                valor = 0d;
                estoque = 0;
                situacao = ' ';
            } //else
        } //try
        catch (Exception erro) {
            erro.printStackTrace(); //imprime no log do servidor
            erro.getMessage(); //recebe a mensagem para que possa ser utilizada em alguma página.
            String urlErro = "/erroAlterar.jsp";
            ServletContext sc = getServletContext(); //variável sc recebe o contexto do servlet (uma página jsp, outro servlet, uma conexão...)
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro); //redireciona o contexto para a url urlErro(string).
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
