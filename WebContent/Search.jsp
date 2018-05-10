<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Food Plaza</title>
</head>
<body>
<input type="hidden" name="action" value="searchfood" >
<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>
		<div align="center">
		<br>
	<form action="FoodServlet" method="post">
		<table>
			<tr>
				<td><input type="text" name="search" placeholder="Search here!"></td>
				<td><input type="submit" value=search></td>
			</tr>
			
		</table>



	</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>