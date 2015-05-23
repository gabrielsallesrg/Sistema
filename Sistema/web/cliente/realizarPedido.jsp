<%@page import="br.com.Modelo.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, br.com.Modelo.*, br.com.Controle.*, java.net.*, java.text.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página destinada à criação do pedido.</title>
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
        
        <form name="realizaPedido" action="RP" method="POST">
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
                    <td> <input type="text" name="txtQuantidade<%+%><%=a.getIdProduto()%>">  </td>
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
