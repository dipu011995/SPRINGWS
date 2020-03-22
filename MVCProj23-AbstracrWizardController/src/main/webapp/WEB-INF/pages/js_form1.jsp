<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color: navy;text-align: center;">Job Portal Register Form1..</h1>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>js_form1</title>
</head>
<body>
	<form:form commandName="regCmd">
		<table border="5">
			<tr>
				<td>Name : </td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Adress : </td>
				<td><form:input path="adress"/></td>
			</tr>
			<tr>
				<td>Age : </td>
				<td><form:input path="age"/></td>
			</tr>
			<tr>
				<td>Contact No : </td>
				<td><form:input path="contactNo"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="_target1" value="Next"></td>
				<td><input type="submit" name="_cancel" value="Cancel"></td>
			</tr>
			
		</table>
		
	</form:form>
</body>
</html>