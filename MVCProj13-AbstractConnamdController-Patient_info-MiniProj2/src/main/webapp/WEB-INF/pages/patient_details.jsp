<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient details</title>
</head>
<body bgcolor="black">

	<h1 style="color: green; text-align: center">PATIENT DETILS...!</h1>

	<c:choose>
		<c:when test="${!empty patientDetails}">
			<h2>Patient List</h2>
			<c:forEach var="patList" items="${patientDetails}">
				<br>
				<br>
				<table border="1"
					style="border-color: green; align-content: center; width: 50%; background-color: lightGreen"
					align="center">
					<tr height="50">
						<td>Date</td>
						<td>${sysDate}</td>
					</tr>
					<tr height="50">
						<td>Patient Id</td>
						<td>${patList.pid}</td>
					</tr>
					<tr height="50">
						<td>Patient Name</td>
						<td>${patList.pname}</td>
					</tr>
					<tr height="50">
						<td>Age</td>
						<td>${patList.age}</td>
					</tr>
					<tr height="50">
						<td>Gender</td>
						<td>${patList.gender}</td>
					</tr>
					<tr height="50">
						<td>Disease</td>
						<td>${patList.disease}</td>
					</tr>
					<tr height="50">
						<td>Doctor Name</td>
						<td>${patList.doctor}</td>
					</tr>
					<tr height="50">
						<td>Patient Word No</td>
						<td>${patList.wordNo}</td>
					</tr>
					<tr height="50">
						<td>Adress</td>
						<td>${patList.adress}</td>
					</tr>
					<tr height="50">
						<td>Contact No</td>
						<td>${patList.contact}</td>
					</tr>
				</table>
			</c:forEach>
		</c:when>
		<c:otherwise><b style="color: red;text-align: center;">No data Found</b></c:otherwise>
	</c:choose>
	
	<br><br>
	<a href="home.htm">HOME</a>
	<br><br>
	<br><br>
	<a href="JavaScript:doPrint()">Print</a>
	<script language="JavaScript">
		function doPrint(){
			frames.focus();
			frames.print();
		}
	</script>

</body>
</html>