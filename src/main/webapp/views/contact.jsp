<!-- Footer -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Contact Us</title>
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/footer.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>
</head>
<body background="resources/static/images/1.jpg">
	<div id="header">
		<div id="logo">
			<img src="../resources/static/images/logo_transparent.png"
				width="120px" height="80px">
		</div>
	<div id="nav">
		<ul>
			<li><a href="../logout">Logout</a></li>
			<li><a href="#news">News</a></li>
			<li class="active"><a href="../customer/contact">Contact</a></li>
			<li><a href="../customer/about">About</a></li>
			<li><a href="../customer/customerDashboard">Home</a></li>
		</ul>
	</div>
</div>
	<div style="background-color: #948f92">
		<div class="contact-container">

			<!-- Grid row-->
			<div class="row py-4 d-flex align-items-center">

				<!-- Grid column -->
				<div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
					<h1 class="mb-0">Get connected with us on social networks!</h1>
				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-6 col-lg-7 text-center text-md-right">

					<!-- Facebook -->
					<a class="fb-ic"> <i class="fab fa-facebook-f white-text mr-4">
					</i>
					</a>
					<!-- Twitter -->
					<a class="tw-ic"> <i class="fab fa-twitter white-text mr-4">
					</i>
					</a>
					<!-- Google +-->
					<a class="gplus-ic"> <i
						class="fab fa-google-plus-g white-text mr-4"> </i>
					</a>
					<!--Linkedin -->
					<a class="li-ic"> <i class="fab fa-linkedin-in white-text mr-4">
					</i>
					</a>
					<!--Instagram-->
					<a class="ins-ic"> <i class="fab fa-instagram white-text">
					</i>
					</a>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row-->

		</div>
	</div>

	<div class="container text-center text-md-left mt-5">

		<div class="row mt-3 dark-grey-text">


			<div class="col-md-3 col-lg-4 col-xl-3 mb-4">
			
				<h1 class="text-uppercase font-weight-bold">T24 SEVEN</h1>

			</div>

			<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">


				<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

					<b>
						<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
							style="width: 60px;">
						<p>
							<i class="fas fa-home mr-3"></i> Mumbai, Maharashtra 10012, India
						</p>
						<p>
							<i class="fas fa-envelope mr-3"></i> t24sevenhelp@gmail.com
						</p>
						<p>
							<i class="fas fa-phone mr-3"></i> + 01 234 567 88
						</p>
						<p>
							<i class="fas fa-print mr-3"></i> + 01 234 567 89
						</p>
					</b>
				</div>

			</div>

		</div>

<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
		</footer>
</body>
</html>