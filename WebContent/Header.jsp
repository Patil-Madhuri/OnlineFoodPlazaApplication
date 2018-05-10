<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
    <% String cuname =(String)session.getAttribute("cusername");
    	String auname = (String)session.getAttribute("ausername");
    	%>
        <ul>
        	<li class="current"><a href="index.jsp"><b>Home</b></a></li>
           <% if(cuname == null && auname ==null) {%>
            <li><a href="AddCustomer.jsp"><b>Register</b></a></li>
            <li><a href="Login.jsp"><b>Login</b></a></li>
            <li><a href="ContactUs.jsp"><b>Contact us</b></a></li>
            <li><a href="Search.jsp"><b>Search</b></a></li>
            <% } %>
            <li ><a href="FoodServlet"><b>Food Menu</b></a></li>
            <%if(cuname != null) {%>
            <li ><a href="CustomerServlet?action=editprofile"><b>Edit Profile</b></a></li>
            <li ><a href="CartServlet?action=showcart"><b>Show Cart</b></a></li>
            <li ><a href="FeedBack.jsp"><b>Feedback</b></a></li>
            <% } %>
            
            <%if(auname != null){ %>
            <li ><a href="AddFood.jsp"><b>Add Food</b></a></li>
            <li ><a href="CustomerServlet"><b>Show Customer</b></a></li>
            <li ><a href="CartServlet?action=showorder"><b>Show Order</b></a></li>
            <li ><a href="FeedBackServlet"><b>Show Feedback</b></a></li>
            <% } %>
            
            <%if(cuname != null || auname != null) {%>
            <li ><a href="ChangePassword.jsp"><b>Change Password</b></a></li>
            <li ><a href="LoginServlet"><b>Logout</b></a></li>
            <% } %>
            
        </ul>
    </div> <!-- end of menu -->
</body>
</html>