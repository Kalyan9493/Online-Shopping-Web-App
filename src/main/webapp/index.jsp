<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Shopping</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="css/home1.css" >

<body >
<div class="w3-top">
  <div class="w3-bar w3-white w3-card" id="myNavbar" >      
    <div class="w3-right w3-hide-small">
      <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>
      <button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign Up</button>
    </div>
  </div>
</div>
<br><br><br><br><br>
<center>
<h1><b><font color="blue">Welcome to online shoping</font></b></h1>
</center>
<br><br><br><br>
<div class="slideshow-container">

  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <img src="img/a.jpg" style="width:100%">
    
  </div>
  
  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <img src="img/b.jpg" style="width:100%">
    
  </div>
  
  <div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <img src="img/ww2.jpg" style="width:100%">
    
  </div>
  </div>
  <br>
  
  <div style="text-align:center">
    <span class="dot" ></span> 
    <span class="dot"></span> 
    <span class="dot"></span> 
  </div>

<!-- Login Page -->
<div id="id01" class="modal">
  <form class="modal-content animate" method="post" action="/login" >
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close">&times;</span>
    </div>

    <div class="container">
      <label for="username"><b>UserName</b></label>
      <input type="text" placeholder="Enter UserName" name="username" >

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" >
        
      <button type="submit">Login </a></button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    </div>      
  </form>
</div>

<!-- Sign Up page -->
<div id="id02" class="modal">
  <form action= "/register" class="modal-content animate" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close">&times;</span>
    </div>

    <div class="container">

      <label for="firstname"><b>First Name</b></label>
      <input type="text" placeholder="Enter firstname" name="firstname" >

      <label for="lastname"><b>Last Name</b></label>
      <input type="text" placeholder="Enter lastname" name="lastname" >

      <label for="emailid"><b>Email Id</b></label>
      <input type="text" placeholder="Enter Email" name="emailid">

      <label for="mobileno"><b>Mobile No</b></label>
      <input type="number" placeholder="Enter Mobile no" name="mobileno" >

      <label for="address"><b>Address</b></label>
      <input type="text" placeholder="Address" name="address" >

      <label for="username"><b>User Name</b></label>
      <input type="text" placeholder="Enter username" name="username" >

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" >
        
      <button type="submit">Sign Up</button>
    </div>
    </div>
  </form>
</div>

<center><h3><font color="green">${msg}</font></h3></center>
<center><h3><font color="red"><b>${errmsg}</b></font></h3></center>
<br>
<br>
<br>
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
setTimeout(showSlides, 2000); 
}
// Get the modal
var modal = document.getElementById('id01');
var modal = document.getElementById('id02');
</script>
</body>
</html>