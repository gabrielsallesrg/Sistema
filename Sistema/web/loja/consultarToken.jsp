<%-- 
    Document   : consultarToken
    Created on : 14/05/2015, 17:59:25
    Author     : ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulte o Token</title>
    </head>
    <body>
    <center>
        <h1>Consultar Token...</h1>
        <br>
        <form action="/cp" method="POST">
        TOKEN - <input type="text">
        <br>
        <br>
        
            <input type="submit" value="Consultar"/>
        </form>   
    </center>
    </body>
</html>
