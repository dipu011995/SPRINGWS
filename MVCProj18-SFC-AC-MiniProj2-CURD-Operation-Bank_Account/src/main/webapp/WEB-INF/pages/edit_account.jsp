<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit_account</title>
</head>
<body bgcolor="navy">
	<form:form method="POST" commandName="editCmd">
		<h1 style="color: lime;text-align: center;"><i>Edit Account Details</i></h1>
		<table align="center"  border="5" style="border-color: green;background: orange;">
			<tr>
				<td>Account No::</td>
				<td><form:input path="accNo" disabled="true"/></td>
			</tr>
			<tr>
				<td>Account Holder Name ::</td>
				<td><form:input path="accHldrName" /></td>
			</tr>
			<tr>
				<td>Adress ::</td>
				<td><form:input path="adress" /></td>
			</tr>
			<tr>
				<td>Adhar Number ::</td>
				<td><form:input path="adharNo" /></td>
			</tr>
			<tr>
				<td>Balance ::</td>
				<td><form:input path="balance" /></td>
			</tr>
			<tr>
				<td>Mobile Number ::</td>
				<td><form:input path="mob" /></td>
			</tr>
			<tr>
				<td><button type="reset">Reset</button></td>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>

</body>
</html>