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
	<h1>Team List</h1><br>
	<a href="admin-home">Home</a><br><br>
		<table border="1">
			<tr>
				<th>Team ID</th>
				<th>Team Name</th>
				<th>Team Status</th>
				<th>Project ID</th>
				<th>####</th>
				<th>#######</th>
			</tr>
			<c:forEach var="t" items="${teams}">
				<tr>
					<td>${t.teamId}</td>
					<td>${t.teamName}</td>
					<td>${t.teamStatus==1 ? "Active" : "Inactive"}</td>
					<td>${t.projectId}</td>
					<td><a href="">Edit</a></td>
					<td><a href="">Details</a></td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</body>
</html>