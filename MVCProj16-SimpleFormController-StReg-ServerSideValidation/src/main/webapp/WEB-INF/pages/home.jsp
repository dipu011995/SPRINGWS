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
				<td><form:input path="sname"  /><br><p style="color:navy;"><form:errors path="sname"/></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Student Adress :</b></td>
				<td><form:input path="saddrs" /><br><p style="color:navy;"><form:errors path="saddrs"/></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Course :</b></td>
				<td><form:input path="course" /><br><p style="color:navy;"><form:errors path="course"/></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Branch :</b></td>
				<td><form:input path="branch" /><br><p style="color:navy;"><form:errors path="branch" /></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Mobile No :</b></td>
				<td><form:input path="mob" /><br><p style="color:navy;"><form:errors path="mob" /></p></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="RESET" /></td>
				<td align="center"><input type="submit" value="REGISTER" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>