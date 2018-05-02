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
<table align="center" border="1" cellpadding="5x" cellspacing="5x">
<caption>Food List</caption>
<tr>
<th> Food Id </th>
<th> Food Name </th>
<th> Food Price </th>
<th> Food Category </th>
<th  colspan="2"> Operation</th>
</tr>

<% List<Food> flist = (List<Food>)session.getAttribute("FoodList"); 
 for(int i=0;i<flist.size();i++) 
	{
		Food f = new Food();
		f = flist.get(i); %>
		<tr>
		<th><%= f.getFood_id() %></th>
		<th><%= f.getFood_name() %></th>
		<th><%= f.getFood_price() %></th>
		<th><%= f.getFood_category()%></th>
		<th><a href ="FoodServlet?action=delete&foodid=<%=f.getFood_id()%>">Delete</a>
			<a href = "FoodServlet?action=update&foodid=<%=f.getFood_id()%>">Update</a>
		</th>
		
		</tr>
		<% } %>

</table>
</body>
</html>