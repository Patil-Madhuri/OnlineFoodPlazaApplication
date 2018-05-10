<%@ page import = "com.foodPlaza.Pojo.Food"%>
<%@ page import= "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Food List</title>
</head>
<body>
<% String auname = (String)session.getAttribute("ausername");
	String cuname =(String) session.getAttribute("cusername");%>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<table align="center" border="1" cellpadding="5x" cellspacing="5x">
<caption>Food List</caption>
<tr>
<th> Food Id </th>
<th> Food Name </th>
<th> Food Price </th>
<th> Food Category </th>
<%if(cuname != null || auname != null){ %>
<th  colspan="3"> Operation</th>
<% } %>
</tr>
<% List<Food> flist = (List<Food>)session.getAttribute("FoodList"); 
 for(int i=0;i<flist.size();i++) 
	{
		Food f = new Food();
		f = flist.get(i); %>
		<tr>
		<td><%= f.getFood_id() %></td>
		<td><%= f.getFood_name() %></td>
		<td><%= f.getFood_price() %></td>
		<td><%= f.getFood_category()%></td>
		<%if(auname != null) { %>
		<th><a href ="FoodServlet?action=delete&foodid=<%=f.getFood_id()%>">Delete</a>
		<th><a href = "FoodServlet?action=update&foodid=<%=f.getFood_id()%>">Update</a></th>
		<% } %>
		<% if(cuname != null){ %>
		<th><a href = "CartServlet?action=addtocart&foodid=<%=f.getFood_id()%>">Add to Cart</a>
		</th>
		<% } %>
		
		</tr>
		<% } %>

</table>
<jsp:include page="Footer.jsp"></jsp:include></div>
</body>
</html>