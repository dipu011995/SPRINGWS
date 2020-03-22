<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register_form</title>
</head>
<body bgcolor="cyan">

	<h1 style="color: lime;text-align: center"><spring:message>${register.Employee}</spring:message></h1>
	
	<form:form modelAttribute="regCmd">
		<table align="center" border="2">
		<tr>
			<td><spring:message>${register.empName}</spring:message></td>
			<td><form:input path="empName"/></td>
		</tr>
		<tr>
			<td><spring:message>${register.empAdress}</spring:message></td>
			<td><form:input path="empAdress"/></td>
		</tr>
		<tr>
			<td><spring:message>${register.empAdress}</spring:message></td>
			<td><form:input path="empDesg"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value=<spring:message>${register.empAdress}</spring:message>></td>
		</tr>
	</table>
	</form:form>
	
	<a href="?locale=${}"></a>

</body>
</html>