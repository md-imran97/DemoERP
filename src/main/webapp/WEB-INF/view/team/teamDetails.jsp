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
<h1>Team Details</h1><br>
<a href="admin-home">Home</a><br>
<br>
<% if(request.getParameter("msg")!=null){out.print(request.getParameter("msg"));} %><br>
<form:form action="team-update" modelAttribute="team" mothod="post">
<table>
<tr>
<td align="right">ID:</td>
<td align="left">${team.teamId}<form:hidden path="teamId"/></td>
</tr>
<tr>
<td align="right">Team Name:</td>
<td align="left"><form:input path="teamName" /></td>
</tr>
<tr>
<td align="right">Team Status:</td>
<td align="left">${team.teamStatus==0?"Inactive":"Active"}</td>
<td><form:select path="teamStatus">
<form:option value="0">Inactive</form:option>
<form:option value="1">Active</form:option>
</form:select></td>
</tr>
<tr>
<td align="right">Project ID:</td>
<td align="left"><a href="project-details?projectId=${team.projectId}">${team.projectId}</a><form:hidden path="projectId" /></td>
</tr>
</table>
<br>
<input type="submit" value="Update" />
</form:form>
<br>
<table border="1">
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Role in Team</th>
<th>Activity in Team</th>
</tr>
<c:forEach var="et" items="${employeeAndTeams}">
				<tr>
					<td><a href="employee-details?empId=${et.employeeId}">${et.employeeId}</a></td>
					<td>${et.employeeName}</td>
					<td>${et.teamRole ==1 ? "Developer":"Team Lead"}</td>
					<td>${et.teamActivity ==1 ? "Active":"Inactive"}</td>
				</tr>			
			</c:forEach>
</table>
</div>
</body>
</html>