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
<h1>Employee Details</h1><br>
<a href="admin-home">Home</a><br>
<br>
<% if(request.getParameter("msg")!=null){out.print(request.getParameter("msg"));} %><br>
<form:form action="employee-update" modelAttribute="employee" mothod="post">
<table>
<tr>
<td align="right">ID:</td>
<td align="left">${employee.employeeId}<form:hidden path="employeeId"/></td>
</tr>
<tr>
<td align="right">Name:</td>
<td align="left"><form:input path="employeeName" /></td>
</tr>
<tr>
<td align="right">Email:</td>
<td align="left"><form:input path="employeeEmail" /></td>
</tr>
<tr>
<td align="right">Designation:</td>
<td align="left"><form:input path="employeeDesignation" /></td>
</tr>
<tr>
<td align="right">Employee Type:</td>
<td align="left">${employee.employeeType==0?"Admin":"Developer"}</td>
<td><form:select path="employeeType">
<form:option value="0">Admin</form:option>
<form:option value="1">Developer</form:option>
</form:select></td>
</tr>
<tr>
<td align="right">Gender:</td>
<td align="left">${employee.employeeGender==0?"Male":"Female"}</td>
<td><form:select path="employeeGender">
<form:option value="0">Male</form:option>
<form:option value="1">Female</form:option>
</form:select></td>
</tr>
<tr>
<td align="right">Status:</td>
<td align="left">${employee.employeeStatus==0?"Inactive":"Active"}</td>
<td><form:select path="employeeStatus">
<form:option value="0">Inactive</form:option>
<form:option value="1">Active</form:option>
</form:select></td>
</tr>
</table>
<br>
<input type="submit" value="Update" />
</form:form>
<br>
<table border="1">
<tr>
<th>Project ID</th>
<th>Project Name</th>
<th>Project Status</th>
<th>Team ID</th>
<th>Team Name</th>
<th>Employee Role</th>
<th>Team Status</th>
</tr>
<c:forEach var="data" items="${data}">
				<tr>
					<td><a href="project-details?projectId=${data.projectId}">${data.projectId}</a></td>
					<td>${data.projectName}</td>
					<td>${data.projectStatus ==1 ? "Active":"Inactive"}</td>
					<td><a href="team-details?teamId=${data.teamId}">${data.teamId}</a></td>
					<td>${data.teamName}</td>
					<td>${data.teamRole==0?"Team lead":"Developer"}</td>
					<td>${data.teamStatus ==1 ? "Active":"Inactive"}</td>
				</tr>			
			</c:forEach>
</table>
</div>
</body>
</html>