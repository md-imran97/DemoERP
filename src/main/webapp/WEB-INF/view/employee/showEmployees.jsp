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
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Employee Designation</th>
				<th>Employee Email</th>
				<th>Employee Gender</th>
				<th>Employee Type</th>
				<th>Employee Status</th>
				<th>#######</th>
				<th>#######</th>
			</tr>
			<c:forEach var="e" items="${employees}">
				<tr>
					<td>${e.employeeId}</td>
					<td>${e.employeeName}</td>
					<td>${e.employeeDesignation}</td>
					<td>${e.employeeEmail}</td>
					<td>${e.employeeGender==0?"Male":"Female"}</td>
					<td>${e.employeeType==0?"Admin":"Developer"}</td>
					<td>${e.employeeStatus ==1 ? "Active":"Inactive"}</td>
					<td><a href="employee-details?empId=${e.employeeId}">Details</a></td>
					<td><a href="">Add Team</a></td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</body>
</html>