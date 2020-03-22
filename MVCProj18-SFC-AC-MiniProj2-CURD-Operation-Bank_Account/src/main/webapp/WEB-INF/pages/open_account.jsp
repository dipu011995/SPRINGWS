<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: blue; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: blue;
}

.button2 {
  background-color: green; 
  color: black; 
  border: 2px solid #008CBA;
}

.button2:hover {
  background-color: #008CBA;
  color: green;
}
</style>

<meta charset="ISO-8859-1">
<title>create_contact</title>
</head>
<body bgcolor="navy">
	<form:form method="POST" commandName="accountCmd">
		<h2 style="color: lime;text-align: center;" >Fill your Details</h2>
		
		<table border="5" style="border-color: red;background-color:purple;;" align="center">
			<tr>
				<td style="color:orange ;">Account Holder Name ::</td>
				<td><form:input path="accHldrName"/></td>
			</tr>
			<tr>
				<td style="color: orange;">Adress ::</td>
				<td><form:input path="adress"/></td>
			</tr>
			<tr>
				<td style="color: orange;">Adhar Number ::</td>
				<td><form:input path="adharNo"/></td>
			</tr>
			<tr>
				<td style="color: orange;">Balance ::</td>
				<td><form:input path="balance"/></td>
			</tr>
			<tr>
				<td style="color: orange;">Mobile Number ::</td>
				<td><form:input path="mob"/></td>
			</tr>		
			<tr>
				<td><button type="reset" class="button button1">Reset</button></td>
				<td><button type="submit" class="button button1">Submit</button></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><a href="viewAccDetails.htm" ><b style="color:lime; ">View All Contacts</b></a></td>
			</tr>
		</table>
	
	</form:form>
	<br><br><br><br>
	
	<center>
	<a href="home.htm"><b style="color: yellow;">HOME</b></a>
	</center>
</body>
</html>