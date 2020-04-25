<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<script src="<c:url value="/resources/static/js/jquery-3.3.0.min.js" />"></script>
<script src="<c:url value="/resources/static/js/bootstrap.min.js" />"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link  href="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>"
	rel="stylesheet" >
		<link href="<c:url value="/resources/static/css/main.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	
	<link href="<c:url value="/resources/static/css/nav2.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/profileDisplay.css"/>"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<title>Mini Statement</title>
<head>



<body style="background:'#dff0d8'">
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

	<center>
	<h1>Detailed Statement</h1>
</center>
	<p>
		<%
			request.getSession().getAttribute("user");
		%>
	</p>
	<table border="1"  align="center"  cellpadding="10">
        <thead>
            <tr>
                <th>Account No</th>
                <th>Transaction Id</th>
                <th>Transaction Date</th>
                <th>Old Balance</th>
                <th>New Balance</th>
                <th>Credit/Debit</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${listTransactions}">
            <tr>
                <td>${product.accountNo}</td>
                <td>${product.transId}</td>
                <td>${product.transDate}</td>
                <td>${product.oldAmount}</td>
                <td>${product.newAmount}</td>
                <td>${product.newAmount-product.oldAmount}</td>
             </tr>
             </c:forEach>
        </tbody>
    </table>
<div class="footer">
	<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
</div>
</body>
