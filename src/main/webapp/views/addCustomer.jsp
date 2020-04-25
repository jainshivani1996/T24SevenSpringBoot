<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
<meta content="noindex, nofollow" name="robots">
<!-- Including CSS File Here -->
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/main.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/static/css/addCustomer.css"/>"
	rel="stylesheet">

<!-- Including JS File Here -->


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
			<!--<li><a href="../customer/about">About Us</a></li>
			<li><a href="#news">News</a></li>
			<li><a href="../customer/contact">Contact Us</a></li> 
			<li><a href="../customer/regForm">Register</a></li> -->
		</ul>
	</div>
</div>
<marquee>
New Offers Awaits <a href="#">Click Here</a>
</marquee>
<marquee direction="right">
Cashback Credit Card <a href="#"><strong>Apply Now</strong></a>
</marquee>
<div style="color:red">${msg}</div>
<div class="content">
<!-- Multistep Form -->
<div class="main">
<form:form id="registrationform" action="saveCustomer" method="post"
		modelAttribute="customer">

<!-- Fieldsets -->
<fieldset id="first">
<h2 class="title">Create your account</h2>

<p class="subtitle">Step 1</p><input name="firstName" id="firstName" placeholder="First Name" type="text" id="firstName" tabindex="1" value="" required>

<input name="lastName" id="lastName"placeholder="Last Name" type="text" value="" id="lastName" tabindex="2"  required>

<input type="email" class="text_field"  name="email" placeholder=" email"  value=""   id="email" tabindex="3" required>
<input type="tel" class="text_field"  name="phoneNo" placeholder=" Phone"   pattern="[0-9]{10}" id="phoneNo" title="Enter correct format" tabindex="4" required>
<input class="text_field" name="password" placeholder=" Password" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  id="password" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required tabindex="5"  >
<label for="birthday" class="birthday" tabindex="4" >Birthday:</label>
<input type="date" id="dob" name="dob" required>




<input class="text_field" name="customerId"  placeholder="Customer Id" type="text" value="" id="customerId" tabindex="6" required>

<input class="text_field" name="street"   placeholder="Address" type="text" id="street" tabindex="7" required>
<input class="text_field" name="city"  placeholder="City" type="text"  id="city" tabindex="8" required>
<input class="text" name="pinCode" placeholder="PinCode" type="number"  pattern="[0-9]{6}" id="pinCode" tabindex="9" required>


<h2 class="title">Account Information</h2>

<input class="text_field" name="adharNo" placeholder="Aadhar Number" type="number" value="" pattern="[0-9]{12}" id="adharNo" tabindex="10" required>




<select class="street" name="branchName" required tabindex="11">
<option>--Branch--</option>
<option value="noida">Noida</option>
<option value="ghaziabad">Ghaziabad</option>
<option value="delhi">Delhi</option>
<option value="gurgaon">Gurgaon</option>
</select>
<select class="accountType" name="accountType" required tabindex="12">
<option>--Account Type--</option>
<option value="Salary">Salary</option>
<option value="Savings">Savings</option>
</select>


<input class="submit_btn" type="submit" value="Submit">
</fieldset>

</form:form>
</div>
</div>
<script>
/*------------Validation Function-----------------*/

</script>
</body>
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</html>
