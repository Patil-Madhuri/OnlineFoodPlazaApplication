<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
<!-- <script type="text/javascript">
function validate()
{
	var cemail = document.getElementById("cemail").value;
	var cpass = document.getElementById("cpass").value;
	var select= document.getElementById("select").value;
	if(cemail=="")
		{
		document.getElementById("cemailError").innerHTML = "Please enter the email";
		return false;
		}
	if(cpass=="")
	{
	document.getElementById("cpassError").innerHTML = "Please enter the password";
	return false;
	}
	if(select=="select")
	{
	document.getElementById("selectError").innerHTML = "Please select category";
	return false;
	}
	return true;
}
</script> -->
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<%String msg =(String)request.getAttribute("msg");
 if(msg != null)
 {
	 out.println(msg);
 }
%>
<div align="center">
<form action="LoginServlet" method="post">
<input type="hidden" name="action" value="login">

<table border="1" cellpadding="5x" cellspacing="5x">
<caption> Login Form</caption>
<tr >
<td>Type</td>
<td>
<select name="type" id="select">
<option value="select">Select</option>
<option value="admin">Admin</option>
<option value="customer">Customer</option>
</select>

</td>
</tr>

<tr>
<td> Username </td>
<td>
<input type="email" name="email" id="cemail" placeholder="Enter email" required>
</td>
</tr>

<tr>
<td>Password</td>
<td> 
<input type="password" name= "pass" id="cpass" placeholder="Enter password" required>
</td>
</tr>


<tr>
<td align="center">
<input type="submit" name="register" value="Log In">
</td>
<td align="center">
<input type="reset" name="reset" value="Clear">
</td>
</tr>
</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>