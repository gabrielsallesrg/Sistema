<%-- 
    Document   : menuloja
    Created on : 14/05/2015, 17:51:22
    Author     : ti
--%>
<%-- ANTIGO
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><body bgcolor ='SkyBlue'>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <br><br><br>
    <center>
        <table cellspacing='10'>
            <tr>
            <font size="4" face="verdana">
            <td><a href="consultarToken.jsp" target="central" >Entregar Pedido</a></td>
            <td><a href="cadastrarProduto.jsp" target="central" >Cadastrar Produto</a></td>
            <td><a href="cadastrarCliente.jsp" target="central" >Cadastrar Cliente</a></td>
            <td><a href="entradaEstoque.jsp" target="central" >Estoque</a></td>
            <td><a href="../index.jsp" target="_top" >Sair</a></td>
            </font>
            </tr>
        </table>
    </center>
    </body>
</html>
--%>

<%-- 
    Document   : menuloja
    Created on : 17/05/2015, 21:14:42
    Author     : Kelvin
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
    <body>

        <div id="menuloja">
            <ul>
                <li><a href="consultarToken.jsp"   target="central" >Entregar Pedido</a></li>
                <li><a href="cadastrarProduto.jsp" target="central" >Cadastrar Produto</a></li>
                <li><a href="alterarProduto.jsp" target="central" >Alterar Produto</a></li>
                <li><a href="alterarEstoque.jsp" target="central" >Alterar Estoque</a></li>
                <li><a href="cadastrarCliente.jsp" target="central" >Cadastrar Cliente</a></li>
                <li><a href="entradaEstoque.jsp"   target="central" >Estoque</a></li>
                <li><a href="../index.jsp"         target="_top" >Sair</a></li>
            </ul>
        </div><!--menuloja-->

    </body>
</html>
