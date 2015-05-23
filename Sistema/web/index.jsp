<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
    <center>
       	<div id="logo">
		<a href="#"><img src="images/logo.svg"></a>
		<div id="texto">
			<p>Não pegue fila. Pegue um ticket</p>
		</div><!--texto-->
	</div><!--logo-->
        
        <br>
        
        <form name="loginUsuario" action="LU" method="POST">
         
           
           <table border="1" cellspacing="1" cellpadding="1">
                            
				<tbody>
					<tr>
						<td id="corpo_form">Nome do Usuario:</td>
						<td><input type="text" name="nome" size="6" /></td>
					</tr>
					<tr>
						<td id="corpo_form">Senha:</td>
						<td><input type="password" name="senha" size="6" /></td>
                                        <tr align="right" >	
                                         
                                            <td></td><td><input type="submit" name="Logar" value="ENTRAR" /></td>
                                        </tr>
                                       
                                
					<tr>
						<td><a href="cadastrarUsuarioCliente.jsp" id="corpo_form">Cadastrar
								Usuario</a></td>
					</tr>
				</tbody>
           </table>
               
          </form>
    </center>
    </body>
    </html>