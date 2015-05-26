<%@page contentType="text/html" pageEncoding="UTF-8"
	import="br.com.Modelo.*, br.com.Controle.*, java.net.*, java.text.*, java.util.*" %>

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
                <center>
		<h1 id="corpo_titulo">CADASTRAR Cliente/Usuario</h1>
		<form name="formLogin" action="CC" method="POST">
			<table border="1" cellspacing="1" cellpadding="1">

				<tbody>
					<tr>
						<td id="corpo_form">Nome:</td>
						<td><input type="text" name="nome"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Sobrenome:</td>
						<td><input type="text" name="sobrenome"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Endereco:</td>
						<td><input type="text" name="endereco"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Cidade:</td>
						<td><input type="text" name="cidade"/></td>
					</tr>                                        
                                        <tr>
						<td id="corpo_form">Telefone:</td>
						<td><input type="text" name="telefone"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">E-mail:</td>
						<td><input type="text" name="email"/></td>
					</tr>
                                        <tr>
						<td id="corpo_form">Nome de Usuario:</td>
						<td><input type="text" name="usuario"/></td>
					</tr>
					<tr>
						<td id="corpo_form">Senha:</td>
						<td><input type="password" name="senha"/></td>
					</tr>
                                        
                                        <% if("L".equals(session.getAttribute("tipo"))) { %>
					<tr>
                                            <td>
                                                Tipo de Login:
                                            </td>
                                                <td>
                                                    <select name="tipo">
                                                        <option value="C" >Cliente</option>
                                                        <option value="L">Loja</option>
                                                    </select>
                                                </td>
                                                
					</tr>
                                        <% } %>
                                       
					<tr>
						<td id="corpo_form">Cadastrar:</td>
						<td><input type="submit" name="Logar" value="Cadastrar" /></td>
					</tr>
				</tbody>
			</table>

		</form>
                </center>
        </div>
</body>
</html>