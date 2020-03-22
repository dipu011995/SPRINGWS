<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>file_upload_form</title>
</head>
<body bgcolor="gray">
	<h1 style="color:lime ;text-align: center">FILE UPLOAD...</h1>
	<form:form method="POST" action="save.htm" modelAttribute="upldCmd" enctype="multipart/form-data">
			<table border="2" align="center" style="border-color: yellow">
				<tr>
					<td style="color:cyan ;"><b>File1 ::</b></td>
					<td style="color:maroon ;"><form:input type="file" path="file1" /></td>
				</tr>
				<tr>
					<td style="color:cyan;"><b>File2 ::</b></td>
					<td style="color:maroon ;"><form:input type="file" path="file2" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Upload" /></td>
				</tr>
			</table>
			
	</form:form>
	
</body>
</html>