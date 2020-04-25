<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!--  -->
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard</title>
<link href="<c:url value="/resources/static/css/admin.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/navStyle.css"/>"
	rel="stylesheet">
	<link href="<c:url value="/resources/static/css/footerStyle.css"/>"
	rel="stylesheet">
		<link href="<c:url value="/resources/static/css/profileDisplay.css"/>"
	rel="stylesheet">
</head>
<body background="../resources/static/images/1.jpg">
	<div id="header">
		<div id="logo">
			<img src="../resources/static/images/logo_transparent.png"
				width="120px" height="80px">
		</div>
	<div id="nav">
		<ul>
			<li class="active"><a href="../adminHome">Home</a></li>
			<li><a href="../customer/about">About Us</a></li>
			<li><a href="#news">News</a></li>
			<li><a href="../customer/contact">Contact Us</a></li>
			<li><a href="../logout">Logout</a></li>
		</ul>
	</div>
	</div>
	<h2>Hello admin</h2>
	<a href="/customer/list">View customer list</a>
	<div class="tab">
		<table border="1" cellpadding="10" align="center">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${listCustomers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/edit">
						<c:param name="customerId" value="${customer.customerId}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="customerId" value="${customer.customerId}" />
					</c:url>

					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<!-- display the update link --> | <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="footer">
		<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
	</div>
</body>
</html>