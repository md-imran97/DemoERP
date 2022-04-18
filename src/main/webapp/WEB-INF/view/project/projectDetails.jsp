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
<h1>Project Details</h1><br>
<a href="admin-home">Home</a><br>
<br>
<% if(request.getParameter("msg")!=null){out.print(request.getParameter("msg"));} %><br>
<form:form action="project-update" modelAttribute="project" mothod="post">
<table>
<tr>
<td align="right">ID:</td>
<td align="left">${project.projectId}<form:hidden path="projectId"/></td>
</tr>
<tr>
<td align="right">Project Name:</td>
<td align="left"><form:input path="projectName" /></td>
</tr>
<tr>
<td align="right">Client Name:</td>
<td align="left"><form:input path="projectClientName" /></td>
</tr>
<tr>
<td align="right">Client Email:</td>
<td align="left"><form:input path="projectClientEmail" /></td>
</tr>
<tr>
<td align="right">Project Status:</td>
<td align="left">${project.projectStatus==0?"Inactive":"Active"}</td>
<td><form:select path="projectStatus">
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
<th>Team ID</th>
<th>Team Name</th>
<th>Team Status</th>
</tr>
<c:forEach var="team" items="${teams}">
				<tr>
					<td><a href="team-details?teamId=${team.teamId}">${team.teamId}</a></td>
					<td>${team.teamName}</td>
					<td>${team.teamStatus ==1 ? "Active":"Inactive"}</td>
				</tr>			
			</c:forEach>
</table>
</div>
</body>
</html>