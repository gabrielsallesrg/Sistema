<%-- 
    Document   : alteraCadastro
    Created on : 26/05/2015, 08:24:30
    Author     : Alan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.Modelo.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.*"%>
<%@page import="br.com.Modelo.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Cadastrar Clientes:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
     <body>
       <%
        String nomesession = session.getAttribute("nome").toString();
        
        UsuarioDao udao = new UsuarioDao();
        Usuario usuario = new Usuario();
        cliente cli = new cliente();
        DAO adao = new DAO();
        
        usuario.setNome(nomesession);
        
              
        usuario = udao.obtemUsuario(usuario);
        cli = adao.retornaCadastroCliente(usuario);
           
        
        %>
        <div id="conteudo">
		<div id="topo"></div>
                <center>
		<h1 id="corpo_titulo">CADASTRAR Cliente/Usuario</h1>
		<form name="formLogin" action="AC" method="POST">
                    <div id="conteudo">
			<table border="1" cellspacing="1" cellpadding="1">

				<tbody>
                                    <% if("C".equals(session.getAttribute("tipo") == null )) {
                                        
                                    %>
                                    	<tr>
						<td id="corpo_form">#</td>
                                                <td><input type="text" name="nome" value="<%= usuario.getId_Log() %>"/></td>
					</tr>
                                     <% } %>
					<tr>
						<td id="corpo_form">Nome:</td>
						<td><input type="text" name="nome" value="<%= usuario.getNome() %>"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Sobrenome:</td>
						<td><input type="text" name="sobrenome" value="<%= cli.getSobrenome() %>"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Endereco:</td>
						<td><input type="text" name="endereco" value="<%= cli.getEndereco()%>"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Cidade:</td>
						<td><input type="text" name="cidade" value="<%= cli.getCidade()%>"/></td>
					</tr>                                        
                                        <tr>
						<td id="corpo_form">Telefone:</td>
						<td><input type="text" name="telefone" value="<%= cli.getTelefone()%>"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">E-mail:</td>
                                                <td><input type="text" name="email" value="<%= cli.getEmail()%>"/></td>
					</tr>
                                        <tr>
                                            <td id="corpo_form">Usuario</td>
                                            <td><input type="text" name="usuario" value="<%= usuario.getNome() %>"/></td>
					</tr>
					<tr>
						<td id="corpo_form">Senha:</td>
						<td><input type="password" name="senha" value="<%= usuario.getSenha() %>"/></td>
					</tr>
                                                                           
					<tr>
						<td id="corpo_form">Alterar:</td>
						<td><input type="submit" name="Logar" value="Alterar" /></td>
					</tr>
				</tbody>
			</table>
                    </div>
		</form>
                </center>
        </div>
    </body>
</html>
