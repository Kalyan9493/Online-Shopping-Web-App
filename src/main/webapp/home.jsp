<!DOCTYPE html>
<html >
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <body style="background-color:powderblue;"> 
    </body>
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
  
    <!-- Custom CSS -->
    
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/home1.css" >
    <link rel="stylesheet" href="css/style.css" >

  </head>
  <body>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <div class="w3-left w3-hide-small">
          <a href="home.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large"><b>Home</b></a>
    
          <div class="w3-dropdown-hover">
            <button  class="w3-button my-account-button button-margin"><b>Products</b></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
              <a href="laptops.html" class="w3-bar-item w3-button">Laptops</a>
              <a href="mobiles.html" class="w3-bar-item w3-button">Mobiles</a>
            </div>
          </div>
          <div class="w3-dropdown-hover">
         <form action="/mycart">
            <input type="submit" class="w3-button my-account-button button-margin" value="My Cart" style="font-weight: bold";>
			</form>
          </div>
          <div class="w3-dropdown-hover">
            <button  class="w3-button my-account-button button-margin"><b>My Account</b></button>
            <div class="w3-dropdown-content w3-bar-block w3-card-4">
              <a href="/viewprofile" class="w3-bar-item w3-button">View Profile</a>
              <a href="Updatedetails.html" class="w3-bar-item w3-button">Update Details</a>           
              <a href="/logout" class="w3-bar-item w3-button">Logout</a>
            </div>
          </div>
        </ul>
  </div> 
 
</div>
</div>
</div>
<br><br><br>
<center><h4><b><font color="blue">Welcome ${name}</font></b></h4></center><br><br>
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
     setTimeout(showSlides, 1800); 
   }
   var modal = document.getElementById('id02');
      </script>
  </body>
</html>