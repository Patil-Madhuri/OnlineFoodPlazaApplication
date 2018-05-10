<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<script type="text/javascript">
function validate()
{
	var newpwd = document.getElementById("newpwd").value;
	var cpwd = document.getElementById("cpwd").value;
	
	if(cpwd=="")
		{
		document.getElementById("cpwdError").innerHTML = "Retype password";
		return false;
		}
	if(cpwd != newpwd)
		{
		document.getElementById("cpwdError").innerHTML = "Retype password";
		return false;
		}
	return true;
}

</script>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<form onsubmit="return validate()" action="LoginServlet" method="post">
<input type="hidden" name="action" value="changepwd">
<table align="center" border="1" cellspacing="5px" cellpadding="5px">
<caption>Change Password</caption>
<tr >
<td>Type</td>
<td>
<select name="type" id="select">
<option value="select">Select</option>
<option value="admin">Admin</option>
<option value="customer">Customer</option>
</select>

<tr>
<td>Old Password</td>
<td>
<input type="password" name="oldpwd" >
</td>
</tr>

<tr>
<td>New Password</td>
<td>
<input type="password" name="newpwd" id="newpwd">
</td>
</tr>

<tr>
<td>Confirm Password</td>
<td>
<input type="password" name="cpwd" id="cpwd">
<span id="cpwdError" style="font-size: small;"></span>
</td>
</tr>

<tr>
<td>
<input type="submit" name="submit" value="OK">
</td>
<td>
<input type="reset" name="reset" value="Clear">
</td>
</tr>
</table>
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>