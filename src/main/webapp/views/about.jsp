<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>About</title>
<link href="<c:url value="/resources/static/css/about.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
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
			<li><a href="../customer/contact">Contact</a></li>
			<li class="active"><a href="out../customer/about">About</a></li>
			<li><a href="../customer/customerDashboard">Home</a></li>
		</ul>
	</div>
	</div>
	<div class="about-section">
		<h1>About Us Page</h1>
		<p>T24 SEVEN Banking application provides safe, secure, timely
			banking solutions.</p>
		<p>The application developed by Wizards At Work provides hassle
			free banking at your fingertips.</p>
	</div>

	<h2 style="text-align: center">Our Team</h2>

	<div class="row">
		<div class="column">
			<div class="card">
				<img src="/w3images/team1.jpg" alt="Shivani" style="width: 100%">
				<div class="about-container">
					<h2>Shivani Jain</h2>
					<p class="title">Developer</p>
					<p>shivani.jain@niit-tech.com</p>
					<p>
						<button class="button">Contact</button>
					</p>
				</div>
			</div>
		</div>

		<div class="column">
			<div class="card">
				<img src="/w3images/team2.jpg" alt="Arpita" style="width: 100%">
				<div class="about-container">
					<h2>Arpita Dwivedi</h2>
					<p class="title">Developer</p>
					<p>arpita.dwivedi@nitt-tech.com</p>
					<p>
						<button class="button">Contact</button>
					</p>
				</div>
			</div>
		</div>

		<div class="column">
			<div class="card">
				<img src="/w3images/team3.jpg" alt="Pratishtha" style="width: 100%">
				<div class="about-container">
					<h2>Pratishtha Sahu</h2>
					<p class="title">Developer</p>
					<p>pratishtha.sahu@niit-tech.com</p>
					<p>
						<button class="button">Contact</button>
					</p>
				</div>
			</div>
		</div>
	</div>

<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>