<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>file_upload_form</title>
</head>
<body>
	<h1 style="color: cyan;text-align: center">FILE UPLOAD...</h1>
	<form:form method="POST" action="save.htm" modelAttribute="upldCmd" enctype="multipart/form-data">
	<!-- 	File1 ::<input type="file" name="file1" /><br>
		File2 ::<input type="file" name="file2" /><br> -->
			File1 ::<form:input type="file" path="file1" /><br>
		    File2 ::<form:input type="file" path="file2" /><br>
		<input type="submit" value="Upload" />
	</form:form>
	
</body>
</html>