<%-- 
    Document   : cadastrarCliente
    Created on : 14/05/2015, 20:01:52
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
--%>
<%-- 
    Document   : cadastrarCliente
    Created on : 19/05/2015, 17:41:02
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

        <title>.:Gakem | Cadastrar Clientes:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>    

    <body>
        <div id="cadastrarclienteh1">     
            <h1>Cadastrar Cliente</h1>
        </div>

        <div id="form-cadastro">
            <fieldset>
                <legend>Cadastro:</legend>

                <form name="cadastrarCliente" action="../CC" method="POST">
                    <table cellspacing="10">
                        <tr>
                            <td>
                                <label for="nome">Nome: </label>
                            </td>

                            <td>
                                <input type="text" name="primeiroNome">
                            </td>
                            <td>
                                <label for="sobrenome">Sobrenome: </label>
                            </td>
                            <td>
                                <input type="text" name="segundoNome">
                            </td>
                        </tr>
                        <td>
                            <label for="endereco">Endereço: </label>
                        </td>
                        <td>
                            <input type="text" name="endereco">
                        </td>

                        <td>
                            <label for="fone">Telefone: </label>
                        </td>                        
                        <td>
                            <input type="text" name="telefone">
                        </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="cidade">Cidade: </label>
                            </td>
                            <td>
                                <input type="text" name="cidade">
                            </td>
                            <td>
                                <label for="email">Email: </label>
                            </td>
                            <td>
                                <input type="text" name="email">
                            </td>
                        </tr>
                    </table>

            </fieldset>
            <br>
            <center>
                <input type="submit" value="Cadastrar">
                <input type="reset" value="Limpar">
            </center>
        </form>
    </div><!--form-cadastro-->
</body>
</html>
