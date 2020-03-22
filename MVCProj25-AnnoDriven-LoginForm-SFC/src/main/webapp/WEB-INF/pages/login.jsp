<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: cyan;text-align: center;">LOGIN FORM</h1>
	
	<form:form modelAttribute="userCmd">
		<table>
		<tr>
			<td>UserName : </td>
			<td><form:input path="user" /></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><form:input path="pwd" /></td>
		</tr>
		<tr>
			<td><input type="reset" value="RESET" /></td>
			<td><input type="submit" value="SUBMIT" /></td>
		</tr>
	</table>
	</form:form>

</body>
</html>