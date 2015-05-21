<%-- 
    Document   : consultarToken
    Created on : 14/05/2015, 17:59:25
    Author     : ti
--%>
<%-- ANTIGO
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
--%>

<%-- 
    Document   : consultarToken
    Created on : 18/05/2015, 17:49:25
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

        <title>.:Gakem | Consulta Token:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head> 
    <body>

        <div id="consulta-token">
            <h1>Consultar Token...</h1>
        </div><!--consulta-token-->

        <div id="form-consultatoken">
            <center>
                <form name="consultarToken" action="../CT" method="POST">
                    TOKEN - <input type="text" name="token">
                    <br>
                    <br>

                    <input type="submit" value="Consultar" name="consultarToken"/>
                </form>   
            </center>
        </div><!--form-consulta token-->
</body>
</html>
