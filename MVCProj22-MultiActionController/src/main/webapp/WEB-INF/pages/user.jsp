<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user</title>
</head>
<body>
<br>

	<c:if test =  "${!operation null}" >
		

	<form:form commandName="">
		Sno :: <form:input path="sno"/><br>
		Sname :: <form:input path="sno"/><br>
		Sadress :: <form:input path="sno"/><br>
		
		<input type="submit" name="s1" value="insert" />
		<input type="submit" name="s1" value="delete" />
		<br>
		<input type="submit" name="s1" value="update" />
		<input type="submit" name="s1" value="view" />
	</form:form>
</body>
</html>