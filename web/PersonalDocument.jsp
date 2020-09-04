<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="srushti.css">

</head>
<body bgcolor=#5296F4>

<header>
        <img src="logo1.png" width="400px" height="50px">
</header>
<div style="float:right">
     
<ul class="navi" >
        <li class="kavi"><a  href="homePage.jsp"><b style="font-size: 15px;" >HOME</b></a></li>
        <li class="kavi"><a href="profilePage"><b style="font-size: 15px;" >PROFILE</b></a></li>
        <li class="kavi"><a href="logoutJava"><b style="font-size: 15px;" >LOGOUT</b></a></li>
</ul>
   
 </div>
<div class="container-fluid">
    
    
    <div id="head" class="row">
    <div class="col-xs-6">
    <div style="float:left">

 </div>
 </div>
    <div class="col-xs-6"></div>
    </div>
    
    <br>
    
    
    <div id="info">
    
  <div id="sru">

      
      <span style="color:black">
        <h1>Fill out your information</h1>
        <form enctype="multipart/form-data" action="PersonalDocumentJava" method="post">
                <input type="hidden" name="email" placeholder="Email" required><br><br>
                <input type="text" name="adharno" placeholder="Adhar Card No" required><br><br>
                
                Aadhaar Card Pic : <input type="file" class="button" name="adharpic" required><br><br>
                
                <input type="text" name="voteridno" placeholder="Voter Id No" required><br><br>
                
                Voter ID Pic : <input type="file" class="button" name="voteridpic" required><br><br>
                
                <input type="text" name="panno" placeholder="PAN Card No" required><br><br>
                
                PAN Card Pic : <input type="file" class="button" name="panpic" required><br><br>
                
                <input type="text" name="drivinglicenceno" placeholder="Driving Licence No" required><br><br>
                
                Driving License Pic : <input type="file" class="button" name="drivinglicencepic" required><br><br>
                
                
                Driving License  Pic : <input type="date"  name="drivinglicenceupto" required><br><br>
                
                <input type="submit" class="button" name="submitinfo"><br><br>
        </form>
        <a href="profilePage"><button style="background-color:#3A5FC1;border: none;color: white;width:100%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px">Go Back</button></a>
      </span>
  </div>
  <br><br>
<footer>
  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>
</footer>

</body>
</html>