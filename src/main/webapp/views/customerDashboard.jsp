<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CustomerDashboard</title>
<link  href="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet" >
<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet" >
	
	
<link href="<c:url value="/resources/static/css/nav2.css"/>"
	rel="stylesheet" >
	
	
	<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
	
<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


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
			<li class="active"><a href="/home">Home</a></li>
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

<div class="left" style="background-image:url('https://images.unsplash.com/photo-1532703108233-69111d554cb4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80'); background-size: cover; ">

</div>
<div class=right" style="margin-top:-270px; display:block; float:right; margin-right:0px;">
<form>
<input type="button" class="gradient-button" value="Check Balance" >
</form>

</div>



<div class="row">

  <div class="column">
    <img src="https://images.unsplash.com/flagged/photo-1573496760140-f15e236b5801?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60" alt="Snow" style="width:100%"/>
	<p><strong>Moving Abroad?</strong><br>Take a look to our dedicated NRI product</p>
  </div>
  
 <div class="column">
   
  	<img src="https://images.unsplash.com/photo-1555400038-63f5ba517a47?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60" alt="Forest" style="width:100%"/><p><strong>Planning for Foreign Trip</strong><br>Whether you're a first-time traveller or traveller, T24SevenBank offers various offers</p>
  </div>
  
  <div class="column">
    <img src="https://images.unsplash.com/photo-1523580846011-d3a5bc25702b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=60" alt="Mountains" style="width:100%">
    <p><strong>Apply for an Educational Loan</strong><br>  with interest rates starting from 10.50%.</p>
  </div>
</div>
<marquee>
<p>
New Cashback Offer <a href="#">Click Here</a> to avail!! Offer Ending Soon....</p>
</marquee>
<div class="row1">
  <div class="column1">
    <img src="https://images.unsplash.com/photo-1511837008003-71eca36ceb70?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="Snow" style="width:100%">
<p><strong><h1>Smart Drive Car Plans</h1></strong><br><h3>Get hassle-free claims settlement with a network of over 3,800 cashless repairers.</h3></p>
  </div>
 <div class="column1">
    <img src="
  https://images.unsplash.com/photo-1560472355-536de3962603?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="Forest" style="width:100%"><p><strong><h1>Cashback Credit card</h1> </strong><br><h3>The card that gives you 1.5% cashback on all online spending and 1% on others with no cap.</h3></p>
  </div>
  <div class="column1">
    <img src="https://images.unsplash.com/photo-1552674605-db6ffd4facb5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80" alt="Mountains" style="width:100%"><p><strong><h1>Smart Health Plan</h1> </strong><br><h3>100% restoration of sum insured, 20 critical illnesses covered and tax deduction benefits..<h3></p>
  </div>
</div>
</body>
<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</html>

