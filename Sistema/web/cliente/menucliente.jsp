<%-- 
    Document   : excluirPedido
    Created on : 17/05/2015, 20:40:26
    Author     : kelvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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


    <div id="menucliente">
        
        <ul>
            <li>Olá, <%= session.getValue("name") %></li>
            <li><a href="realizarPedido.jsp" target="central" >Fazer Pedido!</a></li>
            <li><a href="relatorioPedido.jsp" target="central" >Relatório</a></li>
            <li><a href="excluirPedido.jsp" target="central" >Excluir Pedido</a></li>
            <li><a href="../index.jsp" target="_top" >Sair</a></li>
        </ul>
    </div><!--menucliente-->

</body>
</html>