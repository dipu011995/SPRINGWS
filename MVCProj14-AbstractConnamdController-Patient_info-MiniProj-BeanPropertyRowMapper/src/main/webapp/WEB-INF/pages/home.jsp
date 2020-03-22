<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<body bgcolor="gray">
	<header style="background-color: maroon;">
		<h1 style="color: lime; text-align: center;">Fill Patient Details
			To Search...</h1>
	</header>
	<br>
	<br>
	<form action="search.htm" method="POST">
		<table border="1" align="center">
			<tr bgcolor="green" style="color: red">
				<b><td>Patient Name</td>
					<td><input type="text" name="pname" /></td></b>
			</tr>
			<br>
			<tr bgcolor="green" style="color: red">
				<b><td>Disease</td>
					<td><input type="text" name="disease" /></td></b>
			</tr>
			<br>
			<tr bgcolor="green" style="color: red">
				<b><td>Doctor</td>
					<td><input type="text" name="doctor" /></td></b>
			</tr>
			<br>
			<tr bgcolor="green" style="color: red">
				<b><td>Adress</td>
					<td><input type="text" name="adress" /></td></b>
			</tr>
			<br>
			<tr bgcolor="green" style="color: red">
				<b>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Submit" " /></td>
				</b>
			</tr>
		</table>
	</form>
</body>
</html>