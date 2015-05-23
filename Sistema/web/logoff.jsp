<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="br.com.Modelo.*, br.com.Controle.*, java.net.*, java.text.*, java.util.*"
	pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>
<body>
	<div id="texto-alteracao">
		<div id="topo"></div>
		<div id="corpo_form">

			<%
				//Destroi as sessions
                            session.invalidate();
			%>
                        <center>
			<h2 id="corpo_titulo">VOCE FOI DESCONECTADO</h2>
			<br /> <br /> <a href="../index.jsp" id="corpo_form">PAGINA DE
				LOGIN</a>
                        </center>
</body>
</html>