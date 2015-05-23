package br.com.Controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.Modelo.Usuario;
import br.com.Modelo.UsuarioDao;

public class AutenticaLogin extends HttpServlet {

    private static final long serialVersionUID = 3902994696077504191L;

    /*
     * Classe responsavel pelo recebimento e conversao de parametros enviados de
     * uma pagina JSP; Distinguir os metodos HTTP; Executar as logicas e regras
     * de negocios
     */
    // Metodo responsavel por atender requisicoes e gerar as respostas
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession(true);
            if (session.isNew()) {
                String incomingURL = request.getRequestURL().toString();
                String URLwithID = response.encodeRedirectURL(incomingURL);
                response.setHeader("Custom-newURL", URLwithID);
            }

            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            if ((nome == null || nome.isEmpty())
                    && (senha == null || senha.isEmpty())) {
                response.sendRedirect("erroLogin.jsp");
                nome = "";
                senha = "";
            } else if ((nome == null || nome.isEmpty())) {
                response.sendRedirect("erroLogin.jsp");
                nome = "";
                senha = "";
            } else if ((senha == null || senha.isEmpty())) {
                response.sendRedirect("erroLogin.jsp");
                nome = "";
                senha = "";
            } else {
                
 
                try{
                
                Usuario usuario = new Usuario(nome, senha);
                UsuarioDao udao = new UsuarioDao();
                
                usuario.setNome(nome);
                usuario.setSenha(senha);
                
                if (udao.verificaUsuario(usuario) == true) {

                    session.putValue("nome", nome);
                    session.putValue("senha", senha);
                    session.putValue("tipo", udao.getTipo_cliente());
                    
                    String URLpage = "/loja/loja.jsp";
                    
        
                    if ("C".equals(udao.getTipo_cliente())) {
                        URLpage = "/cliente/cliente.jsp";
                        
                    } else {
                        URLpage = "/loja/loja.jsp";
                    }
                    
                    ServletContext sc = getServletContext(); 
                    RequestDispatcher rd = sc.getRequestDispatcher(URLpage);
                    rd.forward(request, response);

                } else {
                    //System.out.println("Login ou senha ivalidos!!!");
                    String URL = "/index.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(URL);
                    rd.forward(request, response);
                }
                
                }catch(Exception e){
                    
                    e.printStackTrace(); // imprime no log do servidor
                    e.getMessage(); // obtem a mensagem pra trabalhar
                    System.out.print(e);
                    String URL = "/erroLogin.jsp";
                    ServletContext sc = getServletContext(); // contexto do servlet
                    RequestDispatcher rd = sc.getRequestDispatcher(URL); // redirecionamento
                    rd.forward(request, response);
                    
                }
                
                
                
                
            }
        } catch (Exception e) {
            // metodo que captura erros ocorridos
            e.printStackTrace(); // imprime no log do servidor
            e.getMessage(); // obtem a mensagem pra trabalhar
            System.out.println(e);
            String URL = "/erroLogin.jsp";
            ServletContext sc = getServletContext(); // contexto do servlet
            RequestDispatcher rd = sc.getRequestDispatcher(URL); // redirecionamento
            rd.forward(request, response);
        }

    }

	// <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
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
