<%-- 
    Document   : relatorioPedido
    Created on : 16/05/2015, 14:25:27
    Author     : Alan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.DAO"%>
<%@page import="br.com.Modelo.pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Histórico de pedidos ::</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <center>
        <h1>:: Histórico de pedidos ::</h1>
        
        <%
            int idCliente=1; //criado para fins de teste
            DAO adao = new DAO();
            List listaPedidos = adao.listaPedidos(idCliente); //pegar o ID do cliente da sessão e enviar como parâmetro
            Iterator pli = listaPedidos.iterator();
        %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Emissao</th>
                    <th>Retirada</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                    <th>TOKEN</th>
                </tr>
            </thead>
            <tbody>
                <%
                while (pli.hasNext()) {
                    pedido a = (pedido) pli.next();
                %> 
                <tr>
                    <td><%= a.getEmissao()  %></td>
                    <td><%= a.getRetirada() %></td>
                    <td><%= a.getQuantidade() %></td>
                    <td><%= a.getValor() %></td>
                    <td><%= a.getToken() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </center>
    </body>
</html>