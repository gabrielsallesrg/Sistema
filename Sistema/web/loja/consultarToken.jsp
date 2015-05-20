<%-- 
    Document   : consultarToken
    Created on : 14/05/2015, 17:59:25
    Author     : ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
            import="br.com.Controle.*, br.com.Modelo.*, br.com.library.*"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulte o Token</title>
    </head>
    <body>
    <center>
        <h1>Consultar Token...</h1>
        <form name="consultarToken" action="../CT" method="POST">
        <br>    
        TOKEN - <input type="text" name="token">
        <br>
        <br>
        
            <input type="submit" value="Consultar" name="consultarToken"/>
        </form>   
    </center>
    </body>
</html>
