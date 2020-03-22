<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sucess_view</title>
</head>
<body bgcolor="black">
	<h1 style="color:lime ;text-align: center">Downloadable Files...</h1>
	
	<c:choose>
		<c:when test="${!empty filesList}">
			<table border="2" align="center" style="border-color: yellow">
				<tr><th style="color:orange ;text-align: center;">File List</th><th style="color:orange ;text-align: center"">Operations</th></tr>
				<c:forEach var="file" items="${filesList}">
					<tr>
					<td style="color:silver; "><b>${file}</b></td><td><a href="download.htm?fileName=${file}">Download</a></td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
	
	
	<br>
	
	<center><a href="upload.htm" style="color: red"><b>HOME</b></a></center>

</body>
</html>