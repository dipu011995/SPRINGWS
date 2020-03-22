<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
	<form:form action="saveStudent.htm" method="POST"  commandName="stRegCmd">
		<table align="center" style="background-color: red;border-color:yellow;" border="5">
			<tr><th colspan="2" align="center"><h3 style="color:lime;background-color: olive; "><i></i>STUDENT REGISTRATION FORM</h3></th></tr>
			<tr>
				<td style="color: green"><b>Student Name :</b></td>
				<td><form:input path="sname"  /></td>
			</tr>
			<tr>
				<td style="color: green"><b>Student Adress :</b></td>
				<td><form:input path="saddrs" /></td>
			</tr>
			<tr>
				<td style="color: green"><b>Course :</b></td>
				<td><form:input path="course" /></td>
			</tr>
			<tr>
				<td style="color: green"><b>Branch :</b></td>
				<td><form:input path="branch" /></td>
			</tr>
			<tr>
				<td style="color: green"><b>Mobile No :</b></td>
				<td><form:input path="mob" /></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="RESET" /></td>
				<td align="center"><input type="submit" value="REGISTER" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>