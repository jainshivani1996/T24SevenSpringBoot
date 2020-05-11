<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Profile</title>
<link href ="<c:url value="https://fonts.googleapis.com/css2?family=Lobster&family=Playfair+Display:ital,wght@1,500&display=swap"/>"rel="stylesheet">
<link href="<c:url value="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@1,500&display=swap"/> "rel="stylesheet">
<link href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>" rel="stylesheet">
<link href="<c:url value="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600&display=swap"/>" rel="stylesheet">

		<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/main.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/static/css/nav2.css"/>"
	rel="stylesheet">
	
	
	<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<style>


}
.display
{
top:50%;
left:50%;
height:500px;
width:90%;
background:#fcffcc;
display:block;
float:left;
text-align:center;


}
.display p h1
{
font-family: 'Playfair Display', serif';
font-size: 20px;
}
.display-1
{
float: left;
  width: 40%;
margin-left:70%;
background:white;
height:400px;
margin-top:-500px;
border:1px solid #e3e3dc;

}

.display-1 img
{
height:50%;
padding:20px;
width:90%;

}
.display:after {
  content: "";
  display: table;
  clear: both;
}
marquee
{
direction:right;
}
#customers
{
font-family: "Playfair Display', serif";
border-collapse:collapse;
width:100%;
height:60%;
}
#customers td, #customers th {
  border:none;
  padding: 8px;
}
#customers tr
{
 padding-top: 12px;
  padding-bottom: 12px;

}
h1
{
font-size:50px;
font-weight:200;
padding-bottom:20px;
text-decoration:underline;

}
#leftt
{
text-align:left;
}
#btn-1
{
background-color: #555555;
border-radius: 8px;
padding: 14px 40px;
cursor:pointer;
margin-left:-100px;
color:white;
}
#btn-1:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}
#btn-2
{
background-color: #555555;
border-radius: 8px;
padding: 14px 40px;
cursor:pointer;
margin-left:30px;
margin-top:20px;
color:white;
}
#btn-2:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}
.new
{
width:80%;
height:200px;
background:white;
margin:20px;
border:1px solid #e3e3dc;
}
 #leftbox { 
                float:left;  
                background:white; 
                width:30%; 
                height:400px;
margin-right:20px;
margin-left:20px;
border:1px solid #e3e3dc;
text-color:blue;
}
            
            #middlebox{ 
                float:left;  
                background:white; 
                width:30%; 
                height:400px; 
border:1px solid #e3e3dc;

margin-left:20px;
margin-right:30px;
            } 
            #rightbox{ 
                float:right; 
                background:white; 
                width:30%; 
                height:400px; 
border:1px solid #e3e3dc;

            } 
.display h2
{
font-style:oblique;
}
.display-1 p
{
font-weight:bolder;
color:orange;
}
#boxes img
{
width:90%;
height:50%;
padding:20px;
}
#leftbox h1
{
font-size:28px;
font-weight:bolder;
color:#3f466e;
text-decoration:none;
}
#leftbox h4
{
color:#92949c;
font-weight:bold;
font-size:18px;
}
#leftbox a
{
color:orange;
font-weight:bolder;
text-decoration:none;
}
#middlebox h1
{
font-size:28px;
font-weight:bolder;
color:#3f466e;
text-decoration:none;
}
#middlebox h4
{
color:#92949c;
font-weight:bold;
font-size:18px;
}
#middlebox a
{
color:orange;
font-weight:bolder;
text-decoration:none;
}
#rightbox h1
{
font-size:28px;
font-weight:bolder;
color:#3f466e;
text-decoration:none;
}
#rightbox h4
{
color:#92949c;
font-weight:bold;
font-size:18px;
}
#rightbox a
{
color:orange;
font-weight:bolder;
text-decoration:none;
}
i {
  margin-right: 10px;
}
.new img
{
widht:70px;
height:200px;
float:left;
}
.new h1
{
font-family: 'Playfair Display', serif';
text-decoration:none;
color:#3f466e;
font-style:oblique;

}
.new h3
{

font-family: 'Lobster', cursive';
font-weight:10;
font-style:oblique;
color:orange;
}
.new p
{
font-weight:100;
font-style:italic;
color:orange
}
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

<div class="display">
<center>
<h1>Personal Details </h1>
</center>
<p>
	
		<%
			request.getSession().getAttribute("user");
		%>
	</p>
<table id="customers">
  <tr>
<th>First Name:</th>

<th id="leftt">${firstName }</th>
</tr>
	<tr>
				<th>Last Name</th>
				<th id="leftt">${lastName }</th>
			</tr>
<tr>
				<th>Account No</th>
				<th id="leftt">${accNo}</th>
			</tr>
<th>Ifsc code</th>
				<th id="leftt">${ifsc}</th>
			</tr>
			<tr>
				<th>Balance</th>
				<th id="leftt">Rs.${accountBal}</th>
			</tr>
			<tr>
				<th>Debit Card No</th>
				<th id="leftt">${debitNo}</th>

			</tr>
			<tr>
				<th>Branch</th>
				<th id="leftt">${branch }</th>

			</tr>

</table>

<button id="btn-2"  onclick="window.location.href='/customer/updateCustomerEmail';">Update Details</button>

<div class="new">
<img src="https://cdn3.vectorstock.com/i/1000x1000/08/97/study-loan-icon-female-person-profile-avatar-vector-21850897.jpg"><h1>Education Loan</h1>
<h3>One Stop Solution for all your problems.</h3>
<br>
<p>Safely pay for all the essentials using Net Banking</p><br>
<p>Make secured payments from the comfort of your home</p>


</div>
<div class="display-1">
<img src="https://images.unsplash.com/photo-1504509670428-2c66853fd9f7?ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=60">
<p><strong><h1>Traveller?</h1></strong>
</p>
<h2> “Never let your memories be greater than your dreams.”</h2>
<p>Get exciting travelling Offers</p>

</div>
<div id = "boxes"> 
           
              
            <div id = "leftbox"> 
              <img src="https://brands.zee5.com/wp-content/uploads/2019/11/Zee5-.jpg">
<h1>Get @50% off on Zee5 Subscription</h1>
<h4>T24Seven Bank Credit Card Offers</h4>
<a href="#"><h3>View Internet Banking Offers</h3><i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>
<i class="fa fa-share-alt  fa-lg"aria-hidden="true"></i>
               
            </div>  
              
            <div id = "middlebox"> 
              <img src="https://www.jagranimages.com/images/newimg/31032020/31_03_2020-youtube_20154511_201613394.jpg">
<h1>Get @40% off on Youtube Subscription</h1>
<h4>T24Seven Bank Subscription Offers</h4>
<a href="#"><h3>View Credit Card Offers</h3><i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>
<i class="fa fa-share-alt  fa-lg"aria-hidden="true"></i>
               
              
            </div> 
              
            <div id = "rightbox"> 
               <img src="https://1000logos.net/wp-content/uploads/2018/04/Hyundai-Logo.png">
                <h1>Get exciting offers on Car Loan</h1>
<h4>T24Seven Bank Car Loans </h4>
<a href="#"><h3>Loans</h3><i class="fa fa-heart-o fa-lg" aria-hidden="true"></i>
<i class="fa fa-share-alt  fa-lg"aria-hidden="true"></i>
               
            </div> 
        </div> 

</div>
<div class="footer">
	<p>&copy; Copyright 2020, All Rights Reserved By Wizards At Work</p>
</div>

</body>
