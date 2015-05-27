<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Não pegue Fila. Pegue um Ticket:.</title>

        <link rel="shortcut icon" href="images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <br>
        <br>
        <h1>Ocorreu um erro. Verifique com o Suporte.</h1>
        <br><br>
        <div>
            <p> - <%= request.getAttribute("operacao") %> </p>
        </div>
            
    </body>
</html>
