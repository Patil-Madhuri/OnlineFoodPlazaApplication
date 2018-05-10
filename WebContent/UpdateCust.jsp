<%@ page import="com.foodPlaza.Pojo.Customer" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
</head>
<script type="text/javascript">
function validate()
{
	 var x = document.getElementsByClassName("valid");
		var count=0;
		for(var i=0;i<x.length;i++)
			{
				if(x[i].value == "")
					{
						x[i].nextElementSibling.style.color ="red";
						x[i].nextElementSibling.innerHTML ="* Fields cannot be blank..!";
						count++;
					}
				
				else if(isNaN(x[2].value))
					{
						x[2].nextElementSibling.style.color ="red";
						x[2].nextElementSibling.innerHTML = "* contact number cannot contain alphabets..!";
						count++;
					}
				/* else if(isNaN(x[2].value) < 10)
					{
					x[2].nextElementSibling.style.color ="red";
					x[2].nextElementSibling.innerHTML = "* contact number must contains 10 digit..!";
					count++;
					} */	  
		 }
	 if(count!=0)
		{
			return false;
		}
	return true;
}
	
	function clearup(x)
	{
		if(x.value != "")
			{
				x.nextElementSibling.innerHTML = "";
			}
	}

</script>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
<% Customer c=(Customer)session.getAttribute("Customer");%>
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
<span style="font-size: small;"></span>
</td>
</tr>

<tr>
<td> Email</td>
<td>
<input type="text" name="cemail" id="cemail" value="<%=c.getCustemail()%>">
<span style="font-size: small;"></span>
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
<span style="font-size: small;"></span> 
</td>
</tr>

<tr>
<td> Address </td>
<td>
<textarea rows="5" cols="20" name="cadd" id="cadd" ><%=c.getAddress()%>
</textarea> 
<span style="font-size: small;"></span> 
</td>
</tr>

<tr>
<td align="center" colspan="2">
<input type="submit" name="submit" value="Update">
</td>
</tr>

</table>
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>