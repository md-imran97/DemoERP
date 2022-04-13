<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.entity.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home page</title>
</head>
<body>
<div align="center">
	<h1>Employee Profile</h1><br>
	<a href="create-project">Create Project</a><br><br>
	<a href="show-projects">Show Projects</a><br><br>
	<a href="create-team">Create Team</a><br><br>
	<a href="show-teams">Show Teams</a><br><br>
	<a href="show-employees">Show Employees</a><br><br>
	<h2>Personal Info:</h2>
	<table border="1">
		<tr>
			<td>ID : </td>
			<td>${userInfo.employeeId}</td>
		</tr>
		<tr>
			<td>Name : </td>
			<td>${userInfo.employeeName}</td>
		</tr>
		<tr>
			<td>Email : </td>
			<td>${userInfo.employeeEmail}</td>
		</tr>
		<tr>
			<td>Designation : </td>
			<td>${userInfo.employeeDesignation}</td>
		</tr>
		<tr>
			<td>Gender : </td>
			<td>
			<%
				Employee employee=(Employee) request.getAttribute("userInfo");
				if(employee.getEmployeeGender()==0){out.print("Male");}
				else{out.print("Female");}
			%>
			</td>
		</tr>
		<tr>
			<td>Employee Type : </td>
			<td>${userInfo.employeeType==0 ? "Admin" : "Developer"}</td>
		</tr>
		<tr>
			<td>Employee Status : </td>
			<td>
				<c:if test="${userInfo.employeeStatus ==1}">Active</c:if>
				<c:if test="${userInfo.employeeStatus ==0}">Inactive</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>