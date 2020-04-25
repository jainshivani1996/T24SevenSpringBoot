<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Apply Now</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Email</title>
<script type="text/javascript">
window.onload = function () {
    var txtPassword = document.getElementById("pin");
    var txtConfirmPassword = document.getElementById("confirmPin");
    txtPassword.onchange = ConfirmPassword;
    txtConfirmPassword.onkeyup =ConfirmPassword;
    function ConfirmPassword() {
        txtConfirmPassword.setCustomValidity("");
        if (txtPassword.value != txtConfirmPassword.value) {
            txtConfirmPassword.setCustomValidity("Pin doesnot match.");
        }
    }
 }
</script>
<link  href="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet" >
	<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
		<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	
		<link href="<c:url value="/resources/static/css/nav2.css"/>"
	rel="stylesheet">
	
		<link href="<c:url value="/resources/static/css/addBalance.css"/>"
	rel="stylesheet">
	<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	




</style>
</head>
<body>
<div id="header">
	<div id="logo">
		<img src="/resources/static/images/logo_transparent.png" width="120px"
			height="80px">
	</div>

	<div id="nav">
		<ul>
		
			<li><a href="../logout">Logout</a></li>
				<li><a href="#news">News</a></li>
			<li><a href="../customer/about">About Us</a></li>
		
			<li><a href="../customer/contact">Contact Us</a></li>
			<li><a href="../customer/customerDashboard">Home</a></li>
		</ul>
	</div>
</div>


<div class="menu-bar">
<ul>
<li><a href="../user/profile">Profile</a></li>

<li><a href="#">Update Details</a>
<div class="sub-menu-1">
<ul>
<li><a href="/customer/updatePassword">Update Password</a></li>
<li><a href="/customer/updateCustomerEmail">Update Personal Details</a></li>
</ul>
</div>
</li>
<li><a href="#">Fund Transfer</a>
<div class="sub-menu-1">
<ul>
<li><a href="/customer/depositBalance">Via Account</a></li>
<li><a href="/customer/transferAmount">Via UPI</a></li>
</ul>
</div>
</li>
<li><a href="/customer/addBalance">Add Balance</a></li>
<li><a href="#">Statement</a>
<div class="sub-menu-1">
<ul>
<li><a href="/customer/miniStatement">Detailed Statement</a></li>
<li><a href="/customer/miniStatementShort">Past 10 Transactions</a></li>
</ul>
</div>
</li>
<li><a href="/customer/generatePin">Change ATM Pin</a></li>

<li><a href="/customer/applyNow">Apply Now</a></li>


</ul>
</div>
<div class="hero">
<div class="form-box">
<div class="button-box">
<div id="btn"></div>
<button type="button" class="toggle-btn" onclick="login()">Apply for Credit Card</button>

</div>

	<form:form id="login" class="input-group" action="applyCreditCard"
		method="post" modelAttribute="customer">
    <input id="firstName" name="firstName" class="input-field" placeholder="FirstName" readonly="readonly"
			value="${customer.firstName}" required  >
    <input id="lastName" name="lastName" class="input-field" placeholder="Last Name" readonly="readonly"
			value="${customer.lastName}" required  >
    <input id="dob" name="dob" class="input-field" placeholder="DOB" readonly="readonly"
			value="${customer.dob}" required  >
     <input id="email" name="email" class="input-field" placeholder="Email" readonly="readonly"
			value="${customer.email}" required  >
			<select class="select-style city" name="emp" required tabindex="12" required>

			<option value="select">Select Your Employement Type</option>
			<option value="savings">Private Sector</option>
			<option value="current">Business</option>
		</select>
   
    <input type="submit" class="submit-btn" name="signup_submit" value="Apply" />
    <div style="color:white">${message}</div>
    <div>${error}</div></form:form>
  </div>	
<div style="color:red">${message}</div>


</div>
</div>



<script>
var x=document.getElementById("login");

var z=document.getElementById("btn");

function login()
{
x.style.left="100px";
y.style.left="450px";
z.style.left="0";
}


</script>
<div class="footer">
		<p>� Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>