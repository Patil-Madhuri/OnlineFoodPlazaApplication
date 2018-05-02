<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Food</title>
<!-- <script type="text/javascript">
function validate()
{
	 var fname=document.getElementById("fname").value;
	var fprice = document.getElementById("fprice").value;
	var select= document.getElementById("select").value;
	
	if(fname=="")
		{
		document.getElementById("fnameError").innerHTML = "Please enter the food name";
		return false;
		}
	if(fprice=="")
		{
		document.getElementById("fpriceError").innerHTML = "Please enter the food price";
		return false;
		}
	if(isNaN(fprice))
		{
		document.getElementById("fpriceError").innerHTML = "Please enter the food price in number";
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
			else if(isNaN(x[1].value))
				{
					x[1].nextElementSibling.style.color ="red";
					x[1].nextElementSibling.innerHTML = "* Enter price in numbers..!"
					count++;
				}
			else if(!isNaN(x[2].value))
				{
					x[2].nextElementSibling.style.color ="red";
					x[2].nextElementSibling.innerHTML = "* please select category.!"
					count++;
				}
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
</head>
<body>
<div align="center">
<form onsubmit="return validate()" action="FoodServlet" method="post">
<input type="hidden" name="action" value="addfood">
<table border="1" cellpadding="5x" cellspacing="5x">
<caption>Add Food</caption>

<tr>
<td> Name</td>
<td>
<input type="text" name="fname" id="fname" placeholder="Enter Food name" class="valid" onblur ="clearup(this)">
<span style="font-size: small;"></span>
</td>
</tr>

<tr>
<td>Price </td>
<td>
<input type="text" name="fprice" id="fprice" placeholder="Enter Food price" class="valid" onblur ="clearup(this)">
<span style="font-size: small;"></span>
</td>
</tr>

<tr>
<td>Category </td>
<td>
<select name="fcat" id="select" class="valid" onblur ="clearup(this)">
<option value="">Select</option>
<option value="Veg">Veg</option>
<option value="Non-veg">Non-Veg</option>
<option value="South Indian">South Indian</option>
</select>
<span style="font-size: small;"></span>
</td>
</tr>

<tr>
<td align="center" colspan="2">
<input type="submit" name="submit" value="Add Food">
<input type="reset" name="Reset" value="Clear">

</td>



</tr>

</table>
</form>
</div>
</body>
</html>