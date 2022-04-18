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
<h1>Create Employee</h1><br>
<a href="admin-home">Home</a><br><br>
${msg}
<form:form action="create-employee" modelAttribute="employee" method="post">

Name: <form:input path="employeeName" placeholder="enter your name"/><br><br>

Gender: Male<form:radiobutton  path="employeeGender" value='0' />
Female<form:radiobutton  path="employeeGender" value='1' /><br><br>

Employee Type: Developer<form:radiobutton path="employeeType" value='1' />
Admin<form:radiobutton path="employeeType" value='0' /><br><br>

Designation: <form:input path="employeeDesignation"/><br><br>

Employee Status: Active<form:radiobutton path="employeeStatus" value='1' />
Inactive<form:radiobutton path="employeeStatus" value='0' /><br><br>

Email: <form:input path="employeeEmail"/>${errEmail}<br><br>
Password: <form:password path="employeePassword"/><br><br>
 
<input type="submit" value="Submit">
</form:form>
</div>
</body>
</html>