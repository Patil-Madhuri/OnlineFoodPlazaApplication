<%@ page import="com.foodPlaza.Pojo.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
<jsp:include page="Header.jsp"></jsp:include>
<form action="CartServlet"></form>
<table border="1px" align="center" style="font-size: 16px">
<tr>
<td>Orderid</td>
<td>Customer mailid</td>
<td>Total bill</td>
<td>Date</td>
<td>Operation</td>
</tr>
<%List<Order> olist=(List<Order>)session.getAttribute("Orderlist");
for(int i=0;i<olist.size();i++)
{
	Order o=new Order();
	o=olist.get(i);%>
	
	<tr>
	<td><%=o.getOrderid()%></td>
	<td><%=o.getCustemailid()%></td>
	<td><%=o.getTotalbill()%></td>
	<td><%=o.getDate() %></td>
	<td><a href="CartServlet?action=deleteorder&orderid=<%=o.getOrderid()%>">Delete</a></td>
	</tr>
<%}%>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include></div>

</body>
</html>