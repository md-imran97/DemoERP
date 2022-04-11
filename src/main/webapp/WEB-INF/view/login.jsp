<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		<div align="center" >
			<h1>DemoERP Login Page</h1><br>
			${error}
			<form:form action="login" method="post" modelAttribute="loginEntity">
			<form:input  path="email" placeholder="Enter your email"/><br><br>
			<form:input type="password" path="password" placeholder="Enter your password"/><br><br>
			<input type="submit" value="Login" >
			</form:form>
		</div>
	</body>
</html>