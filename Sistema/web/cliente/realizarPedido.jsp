<%@page import="br.com.Modelo.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, br.com.Modelo.*, br.com.Controle.*, java.net.*, java.text.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página destinada à criação do pedido.</title>
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
        <h1>Realize um pedido</h1>
        
        <%
            DAO adao = new DAO();
            List listaProdutos = adao.listaProdutos();
            Iterator pli = listaProdutos.iterator();
        %>
        
        <br>
    <center>
        
        <form name="realizaPedido" action="../RP" method="POST">
        <table border="1" cellspacing="2">
            <thead>
                <tr>
                    <th> - </th>
                    <th>Código</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                </tr>
            </thead>
                   <%
                    while (pli.hasNext()) {
                        produtos a = (produtos) pli.next();
                    %> 
            <tbody>
                <tr>
                    <td><input type="checkbox" name="checado" value="<%= a.getIdProduto() %>"> </td>
                    <td> <%= a.getIdProduto() %>   </td>
                    <td> <%= a.getDescricao() %> </td>
                    <td> <input type="text" name="qtdprodutos" size="4"></td>
                    <td> <%= a.getValor()  %></td>
                </tr>                
            </tbody>
            <% 
                    } //while 
            %>
        </table>            
            <input type="submit" name="Avançar">            
        </form>
    </center>

        
        <br>
    </body>
</html>
