<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color: navy;text-align: center;">Job Portal Register Form3..</h1>
    
    
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>js_form3</title>
</head>
<body>
	<form:form commandName="regCmd">
		<table border="5">
			<tr>
				<td>Prefer Location : </td>
				<td><form:input path="preferLocation"/></td>
			</tr>
			<tr>
				<td>Expected Salary : </td>
				<td><form:input path="expSalary"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="_target1" value="Previous"></td>
				<td><input type="submit" name="_finish" value="Finish"></td>
				<td><input type="submit" name="_cancel" value="Cancel"></td>
			</tr>
			
		</table>
		
	</form:form>
</body>
</html>