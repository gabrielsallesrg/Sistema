<%-- 
    Document   : cadastrarProduto
    Created on : 14/05/2015, 19:56:05
    Author     : Alan
--%>
<%-- ANTIGO

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

--%>

<%-- 
    Document   : cadastrarProduto
    Created on : 18/05/2015, 17:40:12
    Author     : Kelvin 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
            import="br.com.Controle.*, br.com.Modelo.*, br.com.library.*"
            %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Cadastrar Produtos:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>    
    <body>

        <div id="cad-produto">
            <h1>Cadastrar Produto</h1>
        </div><!--cad-produto-->
        <% System.out.println("cadastrarProduto.jsp"); %>
        <div id="tab-cadproduto">
            <center>
                <form name="cadastrarProduto" action="../CP" method="POST">
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
            </center>
        </div><!--tab-cadproduto-->
        <br>
        <input type="submit" value="Cadastrar">
    

</body>
</html>
