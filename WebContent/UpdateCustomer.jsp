<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Profile</title>
</head>
<!-- <script type="text/javascript">
function validate()
{
	var cname = document.getElementById("cname").value;
	var cemail = document.getElementById("cemail").value;
	var cphone = document.getElementById("cphone").value;
	var cadd=document.getElementById("cadd").value;
	if(cname=="")
	{
	document.getElementById("cnameError").innerHTML = "Please enter the name";
	return false;
	}
	if(!isNaN(cname))
	{
	document.getElementById("cnameError").innerHTML = "Customer name doesn't contain numbers";
	return false;
	}
	if(cemail=="")
	{
		document.getElementById("cemailError").innerHTML = "Please enter the email";	
		return false;
	}
	if(cphone=="")
	{
	document.getElementById("cphoneError").innerHTML = "Please enter the contact number";
	return false;		
	}
	if(isNaN(cphone))
	{
	document.getElementById("cphoneError").innerHTML = "Please enter the contact number in number";
	return false;
	}
	if(cphone.length<10)
	{
	document.getElementById("cphoneError").innerHTML = "Please enter the contact number in 10 digits ";
	return false;
	}
	if(cadd=="")
		{
		document.getElementById("caddError").innerHTML = "Please enter the address ";
		return false;
		}
	return true;
}
</script> -->

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
<form onsubmit="return validate()">
<table border="1" align="center" cellpadding="5x" cellspacing="5x">
<caption> Update Profile</caption>
<tr>
<td>Name</td>
<td>
<input type="text" name="cname" id="cname" placeholder="Enter customer name" class="valid" onblur="clearup(this)">
<span style="font-size: small;"></span> 
</td>
</tr>

<tr>
<td>Email</td>
<td>
<input type="text" name="cemail" id="cemail" placeholder="Enter customer email" class="valid" onblur="clearup(this)">
<span style="font-size: small;"></span> 
</td>
</tr>

<tr>
<td>Contact No</td>
<td>
<input type="text" name="cphone" id="cphone" placeholder="Enter customer contact no" class="valid" onblur="clearup(this)">
<span style="font-size: small;"></span> 
</td>
</tr>

<tr>
<td> Address </td>
<td>
<textarea rows="5" cols="20" name="cadd" id="cadd" placeholder="Enter cutomer address" class="valid" onblur="clearup(this)">
</textarea> 
<span style="font-size: small;"></span>
</td>
</tr>

<tr>
<td align="center">
<input type="submit" name="update" value="Update" >
</td>
<td align="center">
<input type="reset" name="reset" value="Clear">
</td>
</tr>
</table>
</form>
</body>
</html>