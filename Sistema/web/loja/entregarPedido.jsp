<%-- ANTIGO

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página destinada à entrega do pedido</title>
    </head>
    <body>
        <h1>Cheque os pedidos para dar baixa</h1>
        
        <br>
        
        <table border="1" cellspacing="2">
            <thead>
                <tr>
                    <th> - </th>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                    <th>Token</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox"> </td>
                    <td>codigo</td>
                    <td>descrição</td>
                    <td>quantidade</td>
                    <td>Valor</td>
                    <td>Token</td>
                </tr>
            </tbody>
        </table>

        
        <br>
    </body>
</html>
--%>

<%-- 
    Document   : entradaEstoque
    Created on : 19/05/2015, 17:51:52
    Author     : Ferraz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Entrega de Pedidos:.</title>
        
        
        <% System.out.println("entregarPedido.jsp"); %>
        
        

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>    
    <body>
        <h1>Cheque os pedidos para dar baixa</h1>
        
        <br>
        
        <table border="1" cellspacing="2">
            <thead>
                <tr>
                    <th> - </th>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                    <th>Token</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox"> </td>
                    <td>codigo</td>
                    <td>descrição</td>
                    <td>quantidade</td>
                    <td>Valor</td>
                    <td>Token</td>
                </tr>
            </tbody>
        </table>

        
        <br>
    </body>
</html>
