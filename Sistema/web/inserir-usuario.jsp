<%@page contentType="text/html" pageEncoding="UTF-8"
	import="br.com.futebol.modelo.*, br.com.futebol.controle.*, java.net.*, java.text.*, java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/menu2.css" rel="stylesheet" type="text/css" />
<meta name="description"
	content=" 
              @Copyright (cc) 2015 USC - Linguagem de Programacao III. Alguns direitos reservados" />
<meta name="author"
	content="
              @author Ericsson Roberto de Barros - ericsson.barros@etec.sp.gov.br" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/pagina1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<title>INSERIR USUARIO</title>

</head>
<body onload="menuDropDown(14);">
	<div id="conteudo">
		<div id="topo"></div>
		<h1 id="corpo_titulo">CADASTRAR USUARIO</h1>
		<form name="formLogin" action="IU" method="POST">
			<table border="1" cellspacing="1" cellpadding="1">

				<tbody>
					<tr>
						<td id="corpo_form">Nome de Usuario:</td>
						<td><input type="text" name="nome" size="50" /></td>
					</tr>
					<tr>
						<td id="corpo_form">Senha:</td>
						<td><input type="password" name="senha" size="6" /></td>
					</tr>
					<tr>
						<td id="corpo_form">Descricao - Quem sou eu (OPCIONAL):</td>
						<td><textarea name="descricao" rows="10" cols="40"></textarea>
						</td>
					</tr>
					<tr>
						<td id="corpo_form">Cadastrar:</td>
						<td><input type="submit" name="Logar" value="Cadastrar" /></td>
					</tr>
				</tbody>
			</table>

		</form>
</body>
</html>