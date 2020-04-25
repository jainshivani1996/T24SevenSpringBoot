<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<title>Statement</title>
	<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/miniStatementStyle.css"/>"
	rel="stylesheet">

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
			<li><a href="../customer/customerDashboard">Home</a></li>
		</ul>
		</div>
	</div>
	<div class="parent">
<div class="one">
 <a	href="/customer/miniStatement"><i>Detailed Statement</i></a>	<br><br>
  <a	href="/customer/miniStatementShort"><i>Past 10 Transactions</i></a>
 </div>
 <div class="two">
<img src="/resources/static/images/1771198.png" alt="Avatar woman"><br>
 </div>
 </div>
			
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>