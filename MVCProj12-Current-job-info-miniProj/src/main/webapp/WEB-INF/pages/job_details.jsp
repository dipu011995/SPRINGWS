<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>job details</title>
</head>
<body bgcolor="gray">
	<h1 style="color: cyan;text-align: center">WELCOME TO JOB-PORTAL...!</h1>
	
	<c:choose>
		<c:when test="${!empty jobList}">
			<table  border="1"  >
				<h3 style="color: black;text-align: center">All Tranding Job On Date:: ${sysDate} </h3>
				<tr bgcolor="lightGreen" bordercolor="green" style="color: red"> 
						<th>Sl No.</th> <th>Job Id</th> <th>Company Name</th> <th>Position</th> <th>Job Profile</th> <th> No. Of Openings Available</th> <th>Experiance Required</th> <th>Salary Range</th> <th>Location</th> 
				</tr>			
				<c:forEach var="dto"  items="${jobList}">
				<tr bgcolor="lightGreen" bordercolor="green" style="color: red">
					<td>${dto.slNo}</td>
					<td>${dto.jobId}</td>
					<td>${dto.companyName}</td>
					<td>${dto.position}</td>
					<td>${dto.jobProfile}</td>
					<td>${dto.noOfPosition}</td>
					<td>${dto.expRange}</td>
					<td>${dto.salaryrange}</td>
					<td>${dto.location}</td>
				</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise> NO Jobs Are Available</c:otherwise>
	</c:choose>

	<br><br>
	<a href="home.htm">HOME</a>
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