<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>Project List</h1><br>
	<a href="admin-home">Home</a><br><br>
		<table border="1">
			<tr>
				<th>Project ID</th>
				<th>Project Name</th>
				<th>Client Name</th>
				<th>Client Email</th>
				<th>Project Status</th>
				<th>####</th>
			</tr>
			<c:forEach var="p" items="${projects}">
				<tr>
					<td>${p.projectId}</td>
					<td>${p.projectName}</td>
					<td>${p.projectClientName}</td>
					<td>${p.projectClientEmail}</td>
					<td>${p.projectStatus ==1 ? "Active":"Inactive"}</td>
					<td><a href="">Edit</a></td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</body>
</html>