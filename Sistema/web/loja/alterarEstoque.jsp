<%-- 
    Document   : alterarEstoque
    Created on : 23/05/2015, 14:40:19
    Author     : Murilo RM
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.DAO"%>
<%@page import="br.com.Modelo.produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Alterar Produto:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>
    <body>
        <%
            DAO dao = new DAO();
            List listaProdutos = dao.listaProdutos(); //pegar o ID do cliente da sessão e enviar como parâmetro
            Iterator pli = listaProdutos.iterator();
        %>  
    <center>
        <div id="cad-produto">
            <h1>Alterar Estoque</h1>
        </div><!--cad-produto-->
        <form name="alterarProduto" action="AE" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>ID do produto</th>
                        <th>Nome</th>
                        <th>Estoque</th>
                        <th>Preço</th>
                        <th>Situação</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    while (pli.hasNext()) {
                        produtos p = (produtos) pli.next();
                    %> 
                    <tr>
                        <td><input type="radio" name="selecionarProduto" value="<%=p.getIdProduto()%>" />"></td>
                        <td><%= p.getIdProduto() %></td>
                        <td><%= p.getDescricao() %></td>
                        <td><%= p.getEstoque() %></td>
                        <td><%= p.getValor() %></td>
                        <td><%= p.getSituacao() %></td>
                    </tr>
                    <%}%>
                </tbody>            
            </table>  
            <hr>
            <p>Insira a mudança no estoque do produto:</p>
            <input type="text" name="txtEstoque" />
            <input type="submit" value="Alterar" name="alterar" />
        </form>
    </center>
    </body>
</html>
