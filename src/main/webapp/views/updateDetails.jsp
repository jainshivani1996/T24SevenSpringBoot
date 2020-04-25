<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<title>Update Details</title>


	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/displayStyle.css"/>"
	rel="stylesheet">
		<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">

<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body background="../resources/static/images/1.jpg">
<div id="header">
		<div id="logo">
			<img src="../resources/static/images/logo_transparent.png"
				width="120px" height="80px">
		</div>
	<div id="nav">
		<ul>
			<li><a href="../logout">Logout</a></li>
			<li><a href="../customer/customerDashboardhome">Home</a></li>
		</ul>
		</div>
	</div>
	<div class="split left">
  <div class="centered">
  <img src="/resources/static/images/short-blond-girl-messaging.png" alt="Avatar woman"><br>

 <a	 href="/customer/updatePhoneNumber">Update Phone</a> 	<br>

 </div>
</div>
<div class="split right">
  <div class="centered">
  <img src="/resources/static/images/email.png" alt="Avatar woman"><br>

			 <a	  href="/customer/updateEmail">Update Email</a>
		
 </div>
</div>	
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>