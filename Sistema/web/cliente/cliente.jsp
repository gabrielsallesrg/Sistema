<%-- 
    Document   : cliente
    Created on : 17/05/2015, 19:53:00
    Author     : kelvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        
        import=" javax.servlet.RequestDispatcher, javax.servlet.ServletContext, javax.servlet.http.HttpServlet "
        
        %>
<%  
        String contextpath  = request.getContextPath();  


        if(session.getAttribute("nome") == null){
            
                    //precisa colocar aqui para redirecionar para outra página
            
        }
        if( "L".equals(session.getAttribute("tipo"))){
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

        <title>.:Gakem | Portal do Cliente:.</title>

        <link rel="shortcut icon" href="../images/favicon.ico">

        <!-- Google fonts -->
        <link href="http://fonts.googleapis.com/css?family=Copse|Montserrat:400,700" rel="stylesheet" type="text/css">

        <!--css-->
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
    </head>


        <FRAMESET ROWS="15%,*" FRAMEBORDER="1" FRAMESPACING="3">
            <FRAME SRC="<%=contextpath%>/cliente/menucliente.jsp" NAME="superior" NORESIZE SCROLLING="NO">
                 <FRAME SRC="<%=contextpath%>/cliente/main.jsp" NAME="central" MARGINWIDTH="2" MARGINHEIGHT="3" NORESIZE SCROLLING="YES">
        </FRAMESET>

  
</html>