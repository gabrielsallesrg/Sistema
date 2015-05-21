<%-- 
    Document   : relatorioPedido
    Created on : 16/05/2015, 14:25:27
    Author     : Alan
--%>

<%@page import="br.com.Modelo.pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            DAO adao = new DAO();
            List listaPedidos = adao.listaPedidos();
            Iterator pli = listaPedidos.iterator();
        %>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Emissao</th>
                    <th>Produto</th>
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
                    <td><%= a.getProduto() %></td>
                    <td><%= a.getQuantidade() %></td>
                    <td><%= a.getValor() %></td>
                    <td><%= a.getToken() %></td>

                </tr>
            </tbody>
        </table>

        
    </body>
</html>