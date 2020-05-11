<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fund Transfer</title>
<link href="<c:url value="/resources/static/css/transferStyle1.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/main.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/static/css/nav2.css"/>"
	rel="stylesheet">
	</head>
<body style="background:url('../resources/static/images/4.jpg')" style="background-position: center" 
   style=" background-size: cover">
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

<div id="login-box">
  <div class="left">
   <center> <h1>TRANSFER VIA ACCOUNT</h1></center>
    <form:form id="depositform" action="depositAmount"
		method="post" modelAttribute="account">
    <input type="text" id="ac" name="ac" value="<%= request.getParameter("payeeAccount") %>" placeholder="Payee Account Number" readonly="readonly" required/>
    <input type="number" min="1" name="balance" placeholder="Deposit Amount" />

    
    
    <input type="submit" name="signup_submit" value="TRANSFER" />
    <div style="color:white">${msg}</div>
    <div>${error}</div></form:form>
  </div>
  
  <div class="right">
    
    
   
    <button class="social-signin twitter"   onclick="window.location.href='/customer/transferAmount';">PAY VIA UPI</button>

  </div>
  <div class="or">OR</div>
</div>
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>