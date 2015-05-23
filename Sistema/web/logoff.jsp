<%-- 
    Document   : logoff
    Disciplina : Linguagem de Programacao III
    Author     : Ericsson
    
    Encerra a sessão do usuario.
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="br.com.futebol.modelo.*, br.com.futebol.controle.*, java.net.*, java.text.*, java.util.*"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/menu2.css" rel="stylesheet" type="text/css" />
<meta name="description"
	content=" 
              @package Menu Principal
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
<title>LOGOFF</title>

</head>
<body onload="menuDropDown(14);">
	<div id="conteudo">
		<div id="topo"></div>
		<div id="corpo_form">

			<%
				//Destroi as sessions
				session.invalidate();
			%>
			<h2 id="corpo_titulo">VOCE FOI DESCONECTADO</h2>
			<br /> <br /> <a href="login.jsp" id="corpo_form">PAGINA DE
				LOGIN</a>
</body>
</html>