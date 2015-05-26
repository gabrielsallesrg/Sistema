package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.produtos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cadastrarProduto extends HttpServlet {

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
            
            System.out.println("cadastrarProduto.java");
            
            String descricao = request.getParameter("descricao");
            //double valor = Double.parseDouble(request.getParameter("valor"));
            double valor;
            String aux_valor = request.getParameter("valor");
            System.out.println(aux_valor);
            if (aux_valor == null || aux_valor.isEmpty()){
                valor = -1; // -1 enviará para a página de erroEstoque.jsp
            }
            else{
                valor = Double.parseDouble(aux_valor);
            }
            //int estoque = Integer.parseInt(request.getParameter("estoque"));
            int estoque;
            String aux_estoque = request.getParameter("estoque");
            if (aux_estoque == null || aux_estoque.isEmpty()){
                estoque = -1; // -1 enviará para a página de erroEstoque.jsp
            }
            else{
                estoque = Integer.parseInt(aux_estoque);
            }
            String situacao = "A";
            
            RequestDispatcher dispatcher;
            ServletContext servletContext = getServletContext();
            dispatcher = servletContext.getRequestDispatcher("/erroEstoque.jsp");
            
            System.out.println("Descrição = " + descricao);
            System.out.println("Estoque = " + estoque);
            System.out.println("Valor = " + valor);
            
            if (estoque > 0)
                situacao = "A"; //Produto automaticamente settado como ativo.
            else if (estoque == 0)
                situacao = "B"; //produto inativo.
            
            
            if (descricao.isEmpty() || descricao == null) {
                System.out.println("cadastrarProduto.java, 66");
                descricao = "";
                dispatcher.forward(request, response);
            }
            else if (valor < 0) {
                System.out.println("cadastrarProduto.java, 71");
                valor = 0d;
                dispatcher.forward(request, response);
            }
            else if (estoque < 0) {
                System.out.println("cadastrarProduto.java, 76");
                estoque = 0;
                dispatcher.forward(request, response);
            }
            else {
                System.out.println("cadastrarProduto.java, 81 else");
                produtos Produto = new produtos(situacao, estoque, descricao, valor);
                DAO dao = new DAO();
                dao.cadastroProduto(Produto);
                String urlOK = "/loja/produtoCadastrado.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(urlOK);
                rd.forward(request, response);
                descricao = "";
                valor = 0d;
                estoque = 0;
                situacao = "";
            } //else
        } //try
        catch (Exception erro) {
            System.out.println("cadastrarProduto.java, catch");
            erro.printStackTrace(); //imprime no log do servidor
            erro.getMessage(); //recebe a mensagem para que possa ser utilizada em alguma página.
           String urlErro = "/erroEstoque.jsp";
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
