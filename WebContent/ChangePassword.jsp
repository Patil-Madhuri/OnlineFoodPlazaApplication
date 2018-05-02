<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<body>
<form>
<table align="center" border="1" cellspacing="5px" cellpadding="5px">
<caption>Change Password</caption>

<tr>
<td>Old Password</td>
<td>
<input type="password" name="oldpwd" >
</td>
</tr>

<tr>
<td>New Password</td>
<td>
<input type="password" name="newpwd" >
</td>
</tr>

<tr>
<td>Confirm Password</td>
<td>
<input type="password" name="cpwd">
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

</body>
</html>