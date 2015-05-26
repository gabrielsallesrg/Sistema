<%-- 
    Document   : login
    Disciplina : Linguagem de Programacao III
    Author     : Ericsson
    
    Pagina de login.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
	import="br.com.futebol.modelo.*, br.com.futebol.controle.*, java.net.*, java.text.*, java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Não pegue Fila. Pegue um Ticket:.</title>

        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
	<div id="conteudo">
		<div id="topo"></div>
		<h1 id="corpo_titulo">LOGIN</h1>
		<form name="formLogin" action="LU" method="POST">
			<table border="1" cellspacing="1" cellpadding="1">

				<tbody>
					<tr>
						<td id="corpo_form">Nome do Usuario:</td>
						<td><input type="text" name="nome" size="6" /></td>
					</tr>
					<tr>
						<td id="corpo_form">Senha:</td>
						<td><input type="password" name="senha" size="6" /></td>
						<td><input type="submit" name="Logar" value="ENTRAR" /></td>
					</tr>
					<tr>
						<td><a href="inserir-usuario.jsp" id="corpo_form">Cadastrar
								Usuario</a></td>
					</tr>
				</tbody>
			</table>

		</form>
	</div>

</body>
</html>