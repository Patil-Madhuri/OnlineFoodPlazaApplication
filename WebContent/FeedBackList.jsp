<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.foodPlaza.Pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Food Plaza</title>
</head>
<body>
	<%String adminName=(String)session.getAttribute("adminName");%>
	<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div align="center">
		<h1>Feedback Lists</h1>
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>Feedback Id</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Comments</th>
				<%if(adminName!=null){ %>
				<th>Confirm</th>
				<%} %>
			</tr>
			<%
				List<FeedBack> flist = (List<FeedBack>) session.getAttribute("FeedBackList");
			%>
			<%
				for (int i = 0; i < flist.size(); i++) {
					FeedBack f = flist.get(i);
			%>

			<tr>
				<td><%=f.getFid()%></td>
				<td><%=f.getCustomerName()%></td>
				<td><%=f.getCustomerEmailId()%></td>
				<td><%=f.getComments()%></td>
				
				<%if(adminName!=null)
				{ %>
				<td><a href="FeedBackServlet?action=Delete&fid=<%=f.getFid()%>">Delete</a></td>
				<%} %>
			</tr>
			<%
				}
			%>
		</table>

	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>