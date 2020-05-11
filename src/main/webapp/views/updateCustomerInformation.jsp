
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Phone Number</title>
<link href="<c:url value="/resources/static/css/style.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
</head>
<body background="<c:url value="/resources/static/images/8CMk2c.jpg"/>" />
<div id="header">
		<div id="logo">
			<img src="../resources/static/images/logo_transparent.png"
				width="120px" height="80px">
		</div>
	<div id="nav">
		<ul>
			<li><a href="../logout">Logout</a></li>
			<li><a href="../customer/customerDashboardhome">Home</a></li>
		</div>
	</div>
<div class="form">
	<h3>Update Phone Number</h3>
	<form:form id="registrationform" action="updatePhoneNumberDetail"
		method="post" modelAttribute="customer">


<br>
				

		<p class="contact">
			<label for="phone">Mobile phone</label>
		</p>
		<input id="phone" name="phoneNo" placeholder="phone number"
			value="${customer.phoneNo}" required tabindex="6" type="tel"
			pattern="[0-9]{10}">
		<br>
		<br>
			<input class="button" name="submit" id="submit" tabindex="16"
			value="Update" type="submit">
	</form:form>

</div>
<div class="footer">
	<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
</div>
</body>
</html>