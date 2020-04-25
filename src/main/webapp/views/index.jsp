<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>T24Seven Bank</title>
<link href="<c:url value="/resources/static/css/main.css" />"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div id="header">
		<div id="logo">
			<img src="../resources/static/images/logo_transparent.png"
				width="120px" height="80px">
		</div>

		<div id="nav">
			<ul>
				<li class="active"><a href="../">Home</a></li>
				<li><a href="user/loginForm">Login</a></li>
				<li><a href="user/loginForm">About Us</a></li>
				<li><a href="user/loginForm">Contact Us</a></li>
			</ul>
		</div>
	</div>

	<div class="slideshow-container">


		<div class="mySlides fade">
			<img src="../resources/static/images/2.jpg" style="width: 100%">
			<div class="caption-text">Welcome to T24Seven Online Banking</div>
		</div>

		<div class="mySlides fade">
			<img src="../resources/static/images/3.jpg" style="width: 100%">
			<div class="caption-text">Welcome to T24Seven Online Banking</div>
		</div>


		<div class="mySlides fade">
			<img src="../resources/static/images/5.jpg" style="width: 100%">
			<div class="caption-text">Welcome to T24Seven Online Banking</div>
		</div>

	</div>
	<br>

	<div style="text-align: center">
		<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
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
		</script>



	<div class="bg-text">
		<h1>Reputation,Respect and Result.</h1>
	</div>
	<div class="main-container">
		<div class="bg-image img2">
			<div class="text left">
			<h3>Banking At your Fingertips</h3>
			Internet Banking offers you the ease and convenience 
			of transacting in an environment you feel most comfortable with. 
			You can check balances and transactions, transfer funds, pay bills, 
			open fixed and recurring deposits and much more.</div>
			<img src="../resources/static/images/piggy.jpg" />
		</div>

		<div class="bg-image img3">
			<img src="../resources/static/images/bitcoin.jpg" />
			<div class="text right">
				<h1>24x7 Security</h1>
				<h5>Our Secure Banking promises you to put your safety and
					Security at the top of our agenda. Switching is simple.We will move
					over your account services and cover all those tricky transactions.
				</h5>
			</div>
		</div>




		<div class="container">
			<div class="box1">
				<img src="../resources/static/images/bank.jpg">
				<p>
					<strong>Online Banking</strong>
				</p>
				<p>Helps you to do online transactions and you need not to go
					Bank and have a sip of coffee in your place.</p>
			</div>

			<div class="box2">
				<img src="../resources/static/images/user.png">
				<p>
					<strong>Pockets By T24Bank</strong>
				</p>
				<p>Money every time on your pocket as it ensures to do online
					payment and transactions any time anywhere!</p>
			</div>

			<div class="box3">
				<img src="../resources/static/images/find.png">
				<p>
					<strong>Find ATMS</strong>
				</p>
				<p>Find the ATM nearby just in one click.Our branch has 3306
					ATMS across the World.</p>
			</div>
		</div>
	</div>
	<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>
