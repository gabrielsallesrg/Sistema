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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DAO dao = new DAO();
            List listaProdutos = dao.listaProdutos(); //pegar o ID do cliente da sessão e enviar como parâmetro
            Iterator pli = listaProdutos.iterator();
        %>      
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
    </body>
</html>
