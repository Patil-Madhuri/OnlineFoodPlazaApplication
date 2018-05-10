<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Food Plaza</title>
</head>
<body>
<input type="hidden" name="action" value="feedBack">
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<br><h1>FeedBack Form:</h1>
<form action="FeedBackServlet" method="post">
<table>
	
	<tr>
	<td>Name:</td><td><input type="text" name="name" placeholder="Enter Name" required></td>
	</tr>
	<tr>
	<td>Email Id:</td><td><input type="email" name="email" placeholder="Enter Email Address" required></td>
	</tr>
	<tr>
	<td>Comments:</td><td><textarea rows="5" cols="21" name="comments" placeholder="Comment here!" required></textarea></td>
	</tr>
	<tr>
	<td><input type="submit" value="Submit" onclick="validate()"></td>
	<td><input type="reset" value="Cancel"></td>
	</tr>
	

</table>

</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</div>

<script type="text/javascript">
function validate()
{
	alert("Click 'OK' to submit feedback!");
}

</script>

</body>
</html>