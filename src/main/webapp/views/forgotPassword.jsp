<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<title>Forgot Password</title>
</head>
<body>
	<form action="#" th:action="@{/forgot-password}" th:object="${user}"
		method="post">
		<table>
			<tr>
				<input id="pass" name="password" type="password"
					placeholder="password" required="true" />
				<br>
				<br>
				<input id="passConfirm" type="password"
					placeholder="Confirm password" required="true" />
			</tr>
			<tr>
				<td><input type="submit" value="Reset Password"></input></td>
			</tr>
		</table>
	</form>
	<div class="footer">
	<p>© Copyright 2020, All Rights Reserved By Wizards At Work</p>
</div>
</body>
</html>