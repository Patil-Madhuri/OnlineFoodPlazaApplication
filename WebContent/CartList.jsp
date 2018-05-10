<%@page import="java.util.List"%>
<%@ page import="com.foodPlaza.Pojo.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Cart</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<form action="CartServlet" method="post">
<table align="center" border="2">
<tr>
<th>Cart Id</th>
<th>Food Name</th>
<th>Food Prize</th>
<th>Quantity</th>
<th>Operation</th>

</tr>
<%List<Cart> clist=(List<Cart>)session.getAttribute("Cartlist");
for(int i=0;i< clist.size();i++)
{ Cart c=new Cart();
   c =clist.get(i);%>
   <tr>
   <td><%= c.getCartid() %></td>
   <td><%= c.getFoodname() %></td>
   <td><%= c.getFoodprice() %></td>
   <%-- <td><%=c.getQuantity() %></td> --%>
   <td><input type="number" name="quantity" value=<%="1"%>>
   		<input type="hidden" name="price" value=<%=c.getFoodprice()%>>
   </td>
   
   <td><a href ="CartServlet?action=delete&cartid=<%=c.getCartid()%>">Delete</a></td>
</tr>

<% } %>

<tr>
<td colspan="5" align="center">
<input type="submit" name="submit" value="Place Order"></td>
</tr>
</table>

</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>