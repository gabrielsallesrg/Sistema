<%-- 
    Document   : pedido
    Created on : 13/05/2015, 19:09:49
    Author     : alan.frigerio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import=""  %>
<!DOCTYPE html>
<html><body bgcolor ='yellow'>
<br>
<h1> Lista de Produtos </h1>
<br>
<center>
<table border='1'>
<thead>
<th><b>*</b></th><th>Código</th><th>Descrição</th><th>Quantidade</th><th>Valor</th>
</thead>

<tbody>   

        
<td><input type="checkbox"></td><td> <%=// Codigo %></td>
<td><%= //Descricao %></td>
<td>
<SELECT name="fonction">
	    <OPTION VALUE="enseignant">0</OPTION>
		<OPTION VALUE="enseignant">1</OPTION>
		<OPTION VALUE="etudiant">2</OPTION>
		<OPTION VALUE="ingenieur">3</OPTION>
		<OPTION VALUE="retraite">4</OPTION>
		<OPTION VALUE="autre">5</OPTION>
		<OPTION VALUE="autre">6</OPTION>
		<OPTION VALUE="autre">7</OPTION>
		<OPTION VALUE="autre">8</OPTION>
</SELECT>
</td>
<td><%= //Valor %></td>
</tr>

<td>-</td><td>-</td><td>-</td><td> <%= //TOTAL %></td><td><%= //TOTAL VALOR %></td>


</tbody>

</table>

<br>
<br>
<b>Totais</b>
<br>
Ítens: Valor:
<br>
<br>

<form method="POST" name="/fp">
    
    <input type="submit" value="enviarpedido" /> 
</form>
</center>

</body></html>