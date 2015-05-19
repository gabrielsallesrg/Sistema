package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class criarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true); //definindo que a sessão é verdadeira
            if (session.isNew()) { //verificar se essa sessão já existe ou não
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);  //coloca um número de identificação na string (ID da sesão)
                response.setHeader("Custom=newURL", URLwithID); //setta o cabeçalho dos documentos de url que rodam no servidor com as novas configurações de identificação do novo usuário da nova sessão
            } //if
            //Formulário do cliente
            String pNome = request.getParameter("primeiroNome"); //obrigatório
            String sNome = request.getParameter("segundoNome"); //obrigatório
            String endereco = request.getParameter("endereco"); 
            String telefone = request.getParameter("telefone"); //obrigatório
            String cidade = request.getParameter("cidade"); //obrigatório
            String email = request.getParameter("email");            
            if (pNome == null || pNome.isEmpty()) {
                pNome = "";
                response.sendRedirect("/erroCliente.jsp");
            } //if
            else if (sNome == null || sNome.isEmpty()) {
                sNome = "";
                response.sendRedirect("/erroCliente.jsp");
            } //else if
            else if (telefone == null || telefone.isEmpty() || (telefone.length() != 11 && telefone.length() != 10)) {
                telefone = "";
                response.sendRedirect("/erroCliente.jsp");
            } //else if
            else if (cidade == null || cidade.isEmpty()) {
                cidade = "";
                response.sendRedirect("/erroCliente.jsp");
            } //else if
            else {
                cliente Cliente = new cliente(telefone, pNome, sNome, endereco, cidade, email); //obj. cliente settado.
                DAO dao = new DAO();
                dao.adicionaCliente(Cliente);
                String urlOK = "/cliente/realizarPedido.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(urlOK);
                rd.forward(request, response);
                pNome = sNome = telefone = cidade = "";
                email = "";
                endereco = "";
            } //else
        } //try
        catch (Exception erro) {
            erro.printStackTrace(); //imprime no log do servidor
            erro.getMessage(); //recebe a mensagem para que possa ser utilizada em alguma página.
            String urlErro = "/erroCliente.jsp";
            ServletContext sc = getServletContext(); //variável sc recebe o contexto do servlet (uma página jsp, outro servlet, uma conexão...)
            RequestDispatcher rd = sc.getRequestDispatcher(urlErro); //redireciona o contexto para a url urlErro(string).
            //rd.forward(request, response);
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
