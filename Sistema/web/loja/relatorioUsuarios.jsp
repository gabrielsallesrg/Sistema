<%@page import="br.com.Modelo.Usuario"%>
<%@page import="br.com.Modelo.UsuarioDao"%>
<%@page import="br.com.Modelo.produtos"%>
<%@page import="br.com.Modelo.pedido"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.DAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Alterar Produto:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>
    <body>
        <%
            UsuarioDao dao = new UsuarioDao();
            List listaUsuario = dao.obtemLista(); //pegar o ID do cliente da sessão e enviar como parâmetro
            Iterator pli = listaUsuario.iterator();
        %>      
        
    <center>
       <div id="cad-produto">
            <h1>Lista Usuários</h1>
        </div><!--cad-produto-->
        <form name="AlteraUsuario" action="../alterarCadastro.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>idUsuaro</th>
                        <th>Nome</th>
                        <th>tipo</th>
                        <th>idCliente</th>
                    </tr>
                </thead>
                
                <tbody>
                    <%
                    while (pli.hasNext()) {
                        Usuario us = (Usuario) pli.next();
                    %> 

                    <tr>
                        
                        <td><input type="radio" name="nome" value="<%= us.getNome() %>"></td>
                        <td><%= us.getNome() %></td>
                        <td><%= us.getTipo() %></td>
                        <td><%= us.getCliente_idCliente() %></td>
                    </tr>
                    <%}%>
                </tbody>            
            </table>  

            <input type="submit">
           </form>

    </center>
    </body>
</html>