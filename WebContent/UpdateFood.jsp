<%@ page import="com.foodPlaza.Pojo.Food" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Food</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<% Food f =(Food)session.getAttribute("Food"); %>
<form action="FoodServlet" method="post">
<input type="hidden" name="action" value="updatefood">
<table align="center" border="1" cellpadding="5x" cellspacing="5x">
<tr>
<td> Id</td>
<td><input type="text" name="fid" value="<%=f.getFood_id()%>"readonly="readonly"></td>
</tr>

<tr>
<td> Name</td>
<td>
<input type="text" name="fname" id="fname" value="<%=f.getFood_name()%>">
</td>
</tr>

<tr>
<td>Price </td>
<td>
<input type="text" name="fprice" id="fprice" value="<%=f.getFood_price()%>">
</td>
</tr>

<tr>
<td>Category </td>
<td>
<input type="text" name="fcat" id="fcat" value="<%=f.getFood_category()%>">
</td>
</tr>


<tr>
<td align="center" colspan="2">
<input type="submit" name="submit" value="Update">

</td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include></div>
</body>
</html>