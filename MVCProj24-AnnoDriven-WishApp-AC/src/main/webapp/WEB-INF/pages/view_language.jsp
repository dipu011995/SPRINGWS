<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view_lang</title>
</head>
<body>
	
<%
Locale[] locale=(Locale[])request.getAttribute("allLocale");
for(Locale l:locale){
	out.println(l.getDisplayLanguage());
	out.println();

%>
<br>
<br>
<% 
}
%>
	
	
</body>
</html>