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
	<div align="center">
	<h1>Create Project</h1><br>
	<a href="admin-home">Home</a><br>
	${msg}<br>
		<form:form action="create-project" modelAttribute="project" method="post">
		Project Name : <form:input path="projectName"/><br><br>
		Client Name : <form:input path="projectClientName"/><br><br>
		Client Email : <form:input path="projectClientEmail"/><br><br>
		Project Status : <form:select type="number" path="projectStatus">
							<form:option value="1" label="Active"></form:option>
							<form:option value="0" label="In Active"></form:option>
						 </form:select><br><br>
						 <input type="submit" value="Add">
		</form:form>
	</div>
</body>
</html>