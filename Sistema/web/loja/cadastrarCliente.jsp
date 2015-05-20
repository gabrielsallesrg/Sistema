<%-- 
    Document   : cadastrarCliente
    Created on : 14/05/2015, 20:01:52
    Author     : Alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
            import="br.com.Controle.*, br.com.Modelo.*, br.com.library.*"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
    <center>
        <h1>Cadastrar Cliente</h1>

        <form name="criarCliente" action="../CC" method="POST">
        
        <table border="0">
            <thead>
                <tr>
                    <th>Primeiro Nome</th>
                    <th>Segundo Nome</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Cidade</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="primeiroNome"></td>
                    <td><input type="text" name="segundoNome"></td>
                    <td><input type="text" name="endereco"></td>
                    <td><input type="text" name="telefone"></td>
                    <td><input type="text" name="cidade"></td>
                    <td><input type="text" name="email"></td>
                </tr>
            </tbody>
        </table>
        
        
            <input type="submit" value="Cadastrar Cliente" name="Cadastrar">
                
        </form>
    </center>
    </body>
</html>
