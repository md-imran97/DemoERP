<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Create Team</h1><br>
<a href="admin-home">Home</a><br><br>
${msg}<br>
<form:form action="create-team" modelAttribute="team" method="post">
Team Name: <form:input path="teamName"/><br><br>
Team Status: <form:select path="teamStatus">
				<form:option value="1">Active</form:option>
				<form:option value="0">Inactive</form:option>
			</form:select><br><br>
Project: <form:select path="projectId">
			<c:forEach var="p" items="${projects}">
				<form:option value="${p.projectId}">${p.projectName}(${p.projectStatus==1 ? "Active":"Inactive"})</form:option>		
			</c:forEach>
		</form:select><br><br>
		<input type="submit" value="Add">
</form:form>
</div>
</body>
</html>