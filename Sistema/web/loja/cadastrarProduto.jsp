<%-- 
    Document   : cadastrarProduto
    Created on : 14/05/2015, 19:56:05
    Author     : Alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
            import="br.com.Controle.*, br.com.Modelo.*, br.com.library.*"
            %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <center>
        <h1>Cadastrar Produto</h1>
        <%
            System.out.println("cadastrarProduto.jsp");
        %>
        
        <form name="cadastrarProduto" action="../CP" method="POST">
        <br>
    
        <table border="1" cellspacing="2">
            <thead>
                <tr>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="descricao"></td>
                    <td><input type="text" name="estoque"></td>
                    <td><input type="text" name="valor"></td>
                </tr>
            </tbody>
        </table>
    
        <br>
        <input type="submit" value="Cadastrar" name="cadastrarProduto">
    </center>    
    </body>
</html>
