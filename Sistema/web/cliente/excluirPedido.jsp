<%-- 
    Document   : excluirPedido
    Created on : 17/05/2015, 19:50:20
    Author     : Kelvin 
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.DAO"%>
<%@page import="br.com.Modelo.pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
     <meta name="viewport" content="width=device-width, initial-scale=1" />
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
     <meta name="viewport" content="width=device-width, initial-scale=1"/>

	 <title>.:Gakem | Excluir Pedido:.</title>

     <link rel="shortcut icon" href="../images/favicon.ico">

     <!-- Google fonts -->
     <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

     <!--css-->
	 <link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
    <body>
    <center>
        <h1>Excluir Pedido</h1>
        <div id="excluirpedido">
            
        </div><!--excluirpedido-->
        <%
            int idCliente=1; //criado para fins de teste
            DAO adao = new DAO();
            List listaPedidos = adao.listaPedidos(idCliente); //pegar o ID do cliente da sessão e enviar como parâmetro
            Iterator pli = listaPedidos.iterator();
        %>      
        <form name="excluirPedido" action="EP" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Emissao</th>
                        <th>TOKEN</th>
                        <th>Quantidade</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    while (pli.hasNext()) {
                        pedido a = (pedido) pli.next();
                    %> 
                    <tr>
                        <td><input type="radio" name="excluirPedido" value="<%=a.getIdPedido()%>" />"></td>               
                        <td><%= a.getEmissao() %></td>
                        <td><%= a.getToken() %></td>
                        <td><%= a.getQuantidade() %></td>
                        <td><%= a.getValor() %></td>                    
                    </tr>
                    <%}%>
                </tbody>            
            </table>  
           <input type="submit" value="Excluir" name="Excluir" />
        </form>
    </center>
    </body>
</html>
