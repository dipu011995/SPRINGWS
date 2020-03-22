<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color: navy;text-align: center;">Job Portal Register Form2..</h1>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>js_form2</title>
</head>
<body>
	<form:form commandName="regCmd">
		<table border="5">
			<tr>
				<td>Domain : </td>
				<td><form:input path="domain"/></td>
			</tr>
			<tr>
				<td>Current Company : </td>
				<td><form:input path="currentCompany"/></td>
			</tr>
			<tr>
				<td>Experiance : </td>
				<td><form:input path="experiance"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="_target0" value="Previous"></td>
				<td><input type="submit" name="_target2" value="Next"></td>
				<td><input type="submit" name="_cancel" value="Cancel"></td>
			</tr>
			
		</table>
		
	</form:form>
</body>
</html>