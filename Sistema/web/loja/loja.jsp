<%-- 
    Document   : loja
    Created on : 14/05/2015, 17:50:21
    Author     : Kelvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
String contextpath          = request.getContextPath();  


        if(session.getAttribute("nome") == null){
            
                    //precisa colocar aqui para redirecionar para outra página
        }
        if( "C".equals(session.getAttribute("tipo"))){
                //aqui precisa dizer que ele não é CLIENTE
            }

%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <meta name="viewport" content="width=device-width, initial-scale=1"/>

        <title>.:Gakem | Portal do Lojista:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>

    <FRAMESET ROWS="15%,*" FRAMEBORDER="1" FRAMESPACING="3">
        <FRAME SRC="<%=contextpath%>/loja/menuloja.jsp" NAME="superior" NORESIZE SCROLLING="NO">
            <FRAME SRC="<%=contextpath%>/loja/main.jsp" NAME="central" MARGINWIDTH="2" MARGINHEIGHT="3" NORESIZE SCROLLING="YES">
                </FRAMESET>
</html>  