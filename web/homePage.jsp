<!DOCTYPE html>
<html>
<title>MAIN HOME PAGE</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Amatic+SC">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, html {
  height: 100%;
  font-family: "Inconsolata", sans-serif;
}

/*.bgimg {
  background-position: center;
  background-size: cover;
  background-image: url("D:/SDL_PROJECT/slide_1.jpg");
  min-height: 75%;
}*/

.menu {
  display: none;
}

footer {
    background-color: #3A5FC1;
    padding: 1px;
    text-align: center;
    color: white;
    font-size:10px;
}

header {
    background-color:#F5F5F5;
    padding: 1px;
    text-align: left;
    font-size:13px;
    color:#666;
}
ul.navi {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color:#3A5FC1;
}

li.kavi {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 10px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #CA175C;
}

.active {
    background-color:red;
}

</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<body>

<header>
        <img src="logo1.png" width="400px" height="50px">
</header>
<% 
String type=(String)session.getAttribute("type"); 
%>

 

<ul class="navi" >
 <div style="float:right">
        <li class="kavi"><a  href="homePage.jsp"><b style="font-size: 15px;" >HOME</b></a></li>
        
        <%
            if(type.equals("police")){
                %><li class="kavi"><a href="policeUserFind.html"><b style="font-size: 15px;" >CHECK USER</b></a></li><%
            }
        %>
        <li class="kavi"><a href="#about" ><b style="font-size: 15px;" >ABOUT US</b></a></li>
        
        <li class="kavi"><a href="#contact"><b style="font-size: 15px;" >CONTACT US</b></a></li>
        <li class="kavi"><a href="profilePage"><b style="font-size: 15px;" >PROFILE</b></a></li>
        <li class="kavi"><a href="logoutJava"><b style="font-size: 15px;" >LOGOUT</b></a></li>
 </div>
</ul>



<!-- Links (sit on top) -->


<!-- Header with image -->
<header class="bgimg w3-display-container w3-grayscale-min" id="home">
 <!-- <div class="w3-display-bottomleft w3-center w3-padding-large w3-hide-small">
    <span class="w3-tag">Open from 6am to 5pm</span>
  </div>
  <div class="w3-display-middle w3-center">-->
   
<div class="slideshow-container">

<div class="mySlides fade">
 
  <img src="slide_1.jpg" style="width:100%">
  
  
</div>

<div class="mySlides fade">
 
  <img src="slide_2.jpg" style="width:100%">
  
</div>

<div class="mySlides fade">
  
  <img src="bg_img.jpg" style="width:100%">
 
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<div class="w3-display-middle w3-center">
    <span class="w3-text-white" style="font-size:90px">WELCOME TO OUR <br>WEBSITE</span>
</div>
 
</header>




<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 5000); // Change image every 2 seconds
}
</script>
<!-- About Container -->
<div class="w3-container w3-padding-64 w3-white w3-grayscale w3-xlarge" id="about">
  <div class="w3-content">
    <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">About Us</h1>
    <p align="justify">All over the world, as per the Motor Vehicles Act of the respective countries, it is compulsory to that citizens always carry the original hard copy of documents like (Registration certificates book, vehicle pollution under control, certificate vehicle Insurance policy). Many times citizens do not remember to carry the vehicle-related documents. When traffic police wanted to verify citizens documents at that time citizens need to carry these documents with them otherwise they need to face consequences.Improving Transparency in system and lots of time should be saved.</p>
  </div>
</div>

 


<!-- Contact -->
 

<div class="w3-padding-32 w3-content " id="contact" >
   
    <hr class="w3-opacity">


    <font face="verdana" color="black" size="3">
    <div style="margin-left: 180px;width:600px;background:yellow;padding:40px;border-radius:20px">
    	<h1  style="margin-bottom:64px;margin-left: 200px;font-family:Impact;">Contact</h1>
    	<p>
            <b>Find us at some address at some place or call us at 05050515-122330<br><br>
    		Permenent Address<br>
    		Church Road, Camp, Pune - 411001,<br> Near Sadhu Vaswani Chowk,<br> Opposite Nuclius Mall (Map)<br>0120456789
                </b>
        </p>
    </div>
    </font>
  </div>

  


<!-- Footer -->
<br><br>
<footer>
  <p>Copyright � 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>
</footer>
</body>
</html>
