<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<Doctype html>
<html lang="en">
<head>
<meta harset="UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1.0">
<title>Login</title>
<head>

<link href="<c:url value="/resources/static/css/loginStyle.css" />"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/static/css/footerStyle.css" />"
	rel="stylesheet">
	
	

<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>

</head>
</head>
<body>
<div id="header">
	<div id="logo">
		<img src="/resources/static/images/logo_transparent.png" width="120px"
			height="80px">
	</div>

	<div id="nav">
		<ul>
			<li><a href="../">Home</a></li>
			<li><a href="../customer/regForm">Register</a></li>
		</ul>
	</div>
</div>
<div class="page-wrapp">

	<div class="left-panell">
		<div class="illustrationn">

		<div class="slideshow-container">

<div class="mySlides fade">
  
  <img src="https://www.federalbank.co.in/image/journal/article?img_id=24221686&t=1587029110306&fileName=Aarogya%20Setu%20App%20-%20Banner%20(1).jpg" style="width:100%">
  <div class="text">

</div>
</div>

<div class="mySlides fade">
 
  <img src="https://ak5.picdn.net/shutterstock/videos/17789425/thumb/1.jpg" style="width:100%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  
  <img src="https://businessdayghana.com/wp-content/uploads/2017/09/online-banking-in-Ghana.jpg
" style="width:100%">
  <div class="text"></div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
		</div>



	
	</div>

	<div class="height">
	<div class="right-panell">
	<h3><strong>Welcome</strong></h3>
	


	<form:form class="animated-formm" action="loginUser"
				method="post" modelAttribute="user">

	<h3>Login to your account</h3>
	<div class="form-group">
		<label for=username"></label>
		<form:input path="customerId" type="text" id="username" class="username" placeholder="Customer Id"/>
	</div>
	<div class="form-group">
		<label for="password"></label>
		<form:input path="password" type="password" id="password" class="password" placeholder="Password"/>
	</div>
<div class="form-group flex-end">	
		<center><input type="submit" value="LOGIN" class="button"/></center>

		

</div>
	
	 <div style="color:#a95858">${error}</div>
	<div style="color:#a95858">${message}</div>
</div>


</div>

</div>
</form:form>

</div>
<div class="FAQs">


<p>FAQs</p>
<button class="collapsible">I have got my Internet Banking User ID and Password; tell me what do I do?</button>
<div class="content">
  <p>You can login with your Internet Banking User ID and Password. 
  When you login for the first time you will get a screen, which will prompt you to change the Password.
   If you have been successful in changing your password, remember to login with the changed password. 
   You will now come to the login home page, which is also called the My overview page.</p>
</div>
<button class="collapsible">What are the transactions that I can do online?</button>
<div class="content">
  <p>You can</p>
	<p>- Check the Balance in your account</p>
	<p>- View/Download mini and detailed statement</p>
	<p>- Check transaction history</p>
	<p>- Transfer funds between your own t24seven Bank A/cs</p>
</div>
<button class="collapsible">How many passwords do I have for Internet Banking?</button>
<div class="content">
  <p>You have only one password for Internet Banking i.e. Login password. 
  The login password, as the name suggests is required to login to your Internet Banking account.</p>
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
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    } 
  });
}
</script>

</body>
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</html>
