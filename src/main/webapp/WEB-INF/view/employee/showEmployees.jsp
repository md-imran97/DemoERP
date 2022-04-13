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
	<h1>Employee List</h1><br>
	<a href="admin-home">Home</a><br><br>
		<table border="1">
			<thead>
				<td>Employee ID</td>
				<td>Employee Name</td>
				<td>Employee Designation</td>
				<td>Employee Email</td>
				<td>Employee Gender</td>
				<td>Employee Type</td>
				<td>Employee Status</td>
				<td>#######</td>
			</thead>
			<c:forEach var="e" items="${employees}">
				<tr>
					<td>${e.employeeId}</td>
					<td>${e.employeeName}</td>
					<td>${e.employeeDesignation}</td>
					<td>${e.employeeEmail}</td>
					<td>${e.employeeGender==0?"Male":"Female"}</td>
					<td>${e.employeeType==0?"Admin":"Developer"}</td>
					<td>${e.employeeStatus ==1 ? "Active":"Inactive"}</td>
					<td><a href="">Details</a></td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</body>
</html>