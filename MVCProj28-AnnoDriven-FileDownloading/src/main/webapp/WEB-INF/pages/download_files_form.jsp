<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sucess_view</title>
</head>
<body>
	<h1 style="color: red;text-align: center">Downloadable Files...</h1>
	
	<c:choose>
		<c:when test="${!empty filesList}">
			<table border="2">
				<tr><th>File List</th><th>Operations</th></tr>
				<c:forEach var="file" items="${filesList}">
					<tr>
					<td>${file}</td><td><a href="download.htm?fileName=${file}">Download</a></td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>

</body>
</html>