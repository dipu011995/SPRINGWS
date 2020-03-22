<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view_details</title>
</head>
<body bgcolor="navy" >
	<h1 style="color: lime;text-align: center">-: Bank Account Details :-   </h1>
	<c:choose>
		<c:when test="${!empty accList}">
			
				<table align="center"  border="5" style="border-color: green;background: orange;">
					<tr style="background-color: purple;">
						<th>Sl No.</th><th>Account Number</th><th>Holder Name</th><th>Adress</th><th>Adhar No</th><th>Balance</th><th>Mobile No.</th><th>Action</th>
					</tr>
					<c:forEach var="acc" items="${accList}" varStatus="status">
						<tr>
							<td> ${status.index+1}</td>
							<td> ${acc.accNo}</td>
							<td> ${acc.accHldrName}</td>
							<td> ${acc.adress}</td>
							<td> ${acc.adharNo}</td>
							<td> ${acc.balance}</td>
							<td> ${acc.mob}</td>
							<td>
								<a  href="editAccount.htm?accNo=${acc.accNo}">EDIT</a>
								&nbsp;&nbsp;&nbsp;
								<a  href="deleteAccount.htm?accNo=${acc.accNo}">DELET</a>
							</td>
						</tr>
					</c:forEach>
				</table>
		</c:when>
		<c:otherwise>Account DoesNot Exits</c:otherwise>
	</c:choose>
	<a href="openAccount.htm"><h2 style="color:lime;text-align: center;">+Create New Account</h2></a>
	<a href="home.htm"><h4 style="color: yellow;text-align: center;">HOME</h4></a>
	</body>
</html>