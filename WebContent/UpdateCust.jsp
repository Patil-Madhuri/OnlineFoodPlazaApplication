<%@ page import="com.foodPlaza.Pojo.Customer" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
</head>
<body>
<% Customer c=(Customer)session.getAttribute("Customer"); %>
<form action="CustomerServlet" method="post">
<input type="hidden" name="action" value="updatecust">
<table border="1" align="center" cellpadding="5x" cellspacing="5x">
<caption>Update Customer</caption>
<tr>
<td> Id </td>
<td>
<input type="text" name="cid" id="cid" value="<%=c.getCustid()%>" readonly="readonly">
</td>
</tr>

<tr>
<td> Name </td>
<td>
<input type="text" name="cname" id="cname" value="<%=c.getCustname()%>">
</td>
</tr>

<tr>
<td> Email</td>
<td>
<input type="email" name="cemail" id= "cemail" value="<%=c.getCustemail()%>">
</td>
</tr>

<%-- <tr>
<td> Password</td>
<td> 
<input type="password" name= "cpass" id="cpass" value="<%=c.getPassword()%>">
</td>
</tr> --%>

<tr>
<td> Contact No </td>
<td>
<input type="text" name="cphone" id="cphone" value="<%=c.getCustphone()%>">
</td>
</tr>

<tr>
<td> Address </td>
<td>
<textarea  type="text" rows="5" cols="20" name="cadd"><%=c.getAddress()%>
</textarea> 
</td>
</tr>

<tr>
<td align="center" colspan="2">
<input type="submit" name="submit" value="Update">

</td>




</table>
</form>
</body>
</html>