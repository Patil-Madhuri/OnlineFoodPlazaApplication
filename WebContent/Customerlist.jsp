<%@ page import = "com.foodPlaza.Pojo.Customer"%>
<%@ page import= "java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
</head>
<body>
<table align="center" border="1" cellpadding="5x" cellspacing="5x">
<caption>Customer List</caption>

<tr>
<td> Id</td>
<td> Name</td>
<td> Email</td>
<!-- <td> Password</td> -->
<td> Contact No</td>
<td> Address</td>
<td colspan="2">Operation</td>
</tr>


<tr>
<% List<Customer> clist = (List<Customer>)session.getAttribute("CustomerList"); 
for(int i=0; i< clist.size();i++)
{
	Customer c = new Customer();
	c = clist.get(i); %>
	
	<tr>
	<td><%= c.getCustid() %></td>
	<td><%= c.getCustname() %></td>
	<td> <%= c.getCustemail() %></td>
	<%-- <td> <%= c.getPassword() %></td> --%>
	<td> <%= c.getCustphone() %></td>
	<td> <%= c.getAddress() %></td>
	
	<td><a href ="CustomerServlet?action=delete&custid=<%=c.getCustid()%>">Delete</a></td>
	<td>	<a href = "CustomerServlet?action=update&custid=<%=c.getCustid()%>">Update</a>
		</td>
	
	<% } %>
</tr>

</table>

</body>
</html>