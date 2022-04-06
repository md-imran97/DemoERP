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
${info}
<form:form action="submitform" modelAttribute="employee" method="post">

Name: <form:input path="name" placeholder="enter your name"/><br>
Gender: Male<form:radiobutton  path="gender" value='1' />
Female<form:radiobutton  path="gender" value='2' /><br>
Employee Type: Development<form:radiobutton path="empType" value='2' />
Admin<form:radiobutton path="empType" value='1' /><br>
Designation: <form:input path="designation"/><br>
Team ID: <form:input type="number" path="teamId"/><br>
Email: <form:input path="email"/>${errEmail}<br>
Password: <form:password path="password"/><br><br>
 
<input type="submit" value="Submit">
</form:form>
</body>
</html>