package br.com.Controle;

import br.com.Modelo.DAO;
import br.com.Modelo.Usuario;
import br.com.Modelo.UsuarioDao;
import br.com.Modelo.cliente;
import java.io.IOException;
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
            String pNome = request.getParameter("nome"); //obrigatório
            String sNome = request.getParameter("sobrenome"); //obrigatório
            String endereco = request.getParameter("endereco"); 
            String telefone = request.getParameter("telefone"); //obrigatório
            String cidade = request.getParameter("cidade"); //obrigatório
            String tipo = request.getParameter("tipo");
            String email = request.getParameter("email");            
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
    
            RequestDispatcher dispatcher;
            ServletContext servletContext = getServletContext();
            dispatcher = servletContext.getRequestDispatcher("/erroCliente.jsp");
            
            if (pNome == null || pNome.isEmpty()) {
                pNome = "";
                dispatcher.forward(request, response);
            } //if
            else if (sNome == null || sNome.isEmpty()) {
                sNome = "";
                dispatcher.forward(request, response);
            } //else if
            else if (usuario == null || usuario.isEmpty()) {
                usuario = "";
                dispatcher.forward(request, response);
            } //else if
            else {
                 
                cliente cli = new cliente(pNome, sNome, endereco, telefone, cidade, email, usuario, senha);
                DAO dao = new DAO();                        
                Usuario user = new Usuario();
                 
                if((session.getAttribute("tipo") == null) || ("C".equals(tipo))){
                        dao.adicionaCliente(cli);
                        user.setTipo("C");
                        user.setIdUsuario((int) dao.retornaIdCliente(usuario));   
                }else {
                    user.setTipo(tipo);
                }
                
                //grava o usuario também

                user.setNome(usuario);
                user.setSenha(senha);
                user.setCliente_idCliente(dao.retornaIdCliente(user.getNome()));
                UsuarioDao userdao = new UsuarioDao();
                userdao.adicionaUsuario(user);
  
                
                String urlOK = "/ok.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(urlOK);
                
                request.setAttribute("operacao", "Seu login é: "+user.getNome());
                
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
