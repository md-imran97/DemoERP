<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<div align="center" >
		${a}<br>
		${msg}<br>
			<form action="login" method="post" class="formcontrol">
			<input type="text" name="email" placeholder="Enter your email"><br><br>
			<input type="password" name="password" placeholder="Enter your password"><br><br>
			<input type="submit" value="Login" >
			</form>
		</div>
	</body>
</html>