<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Food Plaza</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
    <%String msg =(String)request.getAttribute("msg");
 if(msg != null)
 {
	 out.println(msg);
 }
%>
    <div id="templatemo_top_dishes">

    	<h1>Recommended Dishes</h1>
        <div class="top_dishes_box">
       	  <img src="images/vadapav.jpeg" alt="image" width="205" height="150"/>
          <h2>vadapav</h2>
            <p>Vadapav is a vegetarian fast food dish native to the Indian state of Maharashtra. The dish consists of a deep fried potato dumpling placed inside a bread bun (pav) sliced almost in half through the middle. <a href="#">Read more...</a></p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/pavbhaji.jpeg" alt="image" width="205" height="150"/>
            <h2>Pav Bhaji</h2>
          <p>Pav bhaji  is a fast food dish from Maharashtra, India, consisting of a thick vegetable curry, fried and served with a soft bread roll <a href="#">Read more...</a></p>
        </div>
        
        <div class="top_dishes_box">
       	  <img src="images/dalkhichadi.jpeg" alt="image" width="205" height="150"/>
            <h2>dal khichadi</h2>
          <p>An elaborate yet easy khichdi that makes a wholesome and delicious meal <a href="#">Read more...</a></p>
      </div>
        
        <div class="top_dishes_box">
       	  <img src="images/templatemo_image_04.jpg" alt="image" />
            <h2>Donec iaculis felis</h2>
          <p>Praesent varius egestas velit. Donec a massa ut pede pulvinar vulputate. Nulla et augue. <a href="#">Read more...</a></p>
        </div>
        
        <div class="cleaner">&nbsp;</div>
    
    </div> <!-- end of top dishes -->
    
    <div id="templatemo_content">
    	<span class="top"></span>
        <div id="templatemo_innter_content">
            
                <div id="templatemo_content_left">
                    <h1>Welcome to our website</h1>
                <img src="images/templatemo_image_05.jpg" alt="image" width="300" height="200" />
                   
                    <p>Donec malesuada elit vel enim. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id velit elementum mi egestas ullamcorper. Vivamus nec dui.</p>
                  <p>Suspendisse vitae nibh ac nunc mattis blandit. Morbi consectetur ullamcorper felis. Nulla nec elit. Aliquam et mauris. Ut euismod congue diam.</p>
                    <a href="#">Read more...</a>
                    
                        
                    <div class="cleaner_with_height">&nbsp;</div>
                
                </div> <!-- end of content left -->
                
                <div id="templatemo_content_right">
                    <h1>What's new?</h1>
                    <div class="right_column_section">
	                    <h2>Special meal for you</h2>
                        <img src="images/templatemo_image_06.jpg" alt="image" />
                        <p>Curabitur turpis. Nulla a risus. Aliquam lectus dui, euismod id, volutpat ac, fringilla eu, ipsum.</p>
                        <a href="#">Read more...</a>
                     </div>
                
                </div> <!-- end of content right -->
        		<div class="cleaner">&nbsp;</div>
        </div>   
        <div class="cleaner" style="background: #fff;">&nbsp;</div> 	
    </div>

<jsp:include page="Footer.jsp"></jsp:include>

<!--  Free CSS Templates by TemplateMo.com  --> 
</div><!-- end of container -->
<!-- templatemo 082 tea and meal -->
<!-- 
Tea And Meal Template 
http://www.templatemo.com/preview/templatemo_082_tea_and_meal 
-->
</body>
</html>
