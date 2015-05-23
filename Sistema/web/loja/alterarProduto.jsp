<%-- 
    Document   : alterarProduto
    Created on : 17/05/2015, 12:30:52
    Author     : Murilo RM
--%>
<%@page import="br.com.Modelo.produtos"%>
<%@page import="br.com.Modelo.pedido"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.com.Modelo.DAO"%>
<%-- ANTIGO
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página para alterar o produto</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
--%>

<%-- 
    Document   : alterarProduto
    Created on : 17/05/2015, 12:30:52
    Author     : Murilo RM
--%>

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
        <form name="alterarProduto" action="SP" method="POST">
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
            <p>Insira as novas propriedades do produto:</p>
            <table border="1" cellspacing="1">
                <thead>
                    <tr>
                        <th>Nome:</th>
                        <th>Preço:</th>
                        <th>Estoque:</th>
                        <th>Situação:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="txtDescricao"/></td>
                        <td><input type="text" name="txtValor"/></td>
                        <td><input type="text" name="txtEstoque"/></td>
                        <td><input type="text" name="txtSituacao"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Alterar" name="alterar" />
        </form>
    </body>
</html>