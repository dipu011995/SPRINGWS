<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <p style="color: bule;">
	<form:errors path="*" />
</p>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<form:form action="saveStudent.htm" method="POST"  commandName="stRegCmd" onsubmit="return (validate(this));">
				
				
		<%-- <table align="center" style="background-color: red;border-color:yellow;" border="5">
			<tr><th colspan="2" align="center"><h3 style="color:lime;background-color: olive; "><i></i>STUDENT REGISTRATION FORM</h3></th></tr>
			<tr>
				<td style="color: green"><b>Student Name :</b></td>
				<td><form:input path="sname"  /><br><p style="color:navy;"><form:errors path="sname"/><span id="snameError" > </span></p></td>
			</tr>
			<tr> 
				<td style="color: green"><b>Student Adress :</b></td>
				<td><form:input path="saddrs" /><br><p style="color:navy;"><form:errors path="saddrs"/><span id="saddrsError"> </span></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Course :</b></td>
				<td><form:input path="course" /><br><p style="color:navy;"><form:errors path="course"/><span id="courseError"> </span></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Branch :</b></td>
				<td><form:input path="branch" /><br><p style="color:navy;"><form:errors path="branch" /><span id="branchError"> </span></p></td>
			</tr>
			<tr>
				<td style="color: green"><b>Mobile No :</b></td>
				<td><form:input path="mob" /><br><p style="color:navy;"><form:errors path="mob" /><span id="mobError"> </span></p></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="RESET" /></td>
				<td align="center"><input type="submit" value="REGISTER" /></td>
			</tr>
		</table> --%>
		
		
		
		<h3 style="color:lime;background-color: olive; "><i>STUDENT REGISTRATION FORM</i></h3>
				<br><br>
				
				Sname ::<form:input path="sname"  /><form:errors path="sname"/><span id="snameError" > </span>
				<br>
				Sadress::<form:input path="saddrs" /><form:errors path="saddrs"/><span id="saddrsError"> </span>
				<br>
				Course::<form:input path="course" /><form:errors path="course"/><span id="courseError"> </span>
				<br>
				Branch::<form:input path="branch" /><form:errors path="branch" /><span id="branchError"> </span>
				<br>
				Mobile::<form:input path="mob" /><form:errors path="mob" /><span id="mobError"> </span>
				<br>
				<form:hidden path="vflag"/>
				<br>
						<input type="reset" value="RESET" />
						<input type="submit" value="REGISTER" />
				<br>
	</form:form>
	
	<style type="text/css">
		span {color:red;font-size: 20px;   }
	</style> 
	
	<script language="JavaScript">
		function 	validate(frm) {
			
			frm.vflag.value =true;
			//read formed data
			var nm = frm.sname.value;
			var addrs = frm.saddrs.value;
			var crs = frm.course.value;
			var brnch = frm.branch.value;
			var mobile = frm.mob.value;
			
			
			document.getElementById("snameError").innerHTML = " ";
			document.getElementById("saddrsError").innerHTML =" ";
			document.getElementById("courseError").innerHTML =" ";
			document.getElementById("branchError").innerHTML =" ";
			document.getElementById("mobError").innerHTML=" ";

			//write server clint from validation logic

			//to check name is null or not
			if (nm == "") {
				document.getElementById("snameError").innerHTML = "Student Name Should Not be Null";
				frm.sname.focus();
				return false;
			}
			//to chech name should not be more then 30 character
			else if (nm.length > 30) {
				document.getElementById("snameError").innerHTML = "Student name Should not be more then 30 character";
				frm.sname.focus();
				return false;
			}
			//to check adress is null or not
			if (addrs == "") {
				document.getElementById("saddrsError").innerHTML = "Student Adress Should Not be Null";
				frm.saddrs.focus();
				return false;
			}
			//to chech adress should not be less then 3 character
			else if (addrs.length <= 3) {
				document.getElementById("saddrsError").innerHTML = "Student Adress Should not be less then 3 character";
				frm.saddrs.focus();
				return false;
			}
			//to check course is null or not
			if (crs == "") {
				document.getElementById("courseError").innerHTML = "Student Course Should Not be Null";
				frm.course.focus();
				return false;
			}
			//to check branch is null or not
			if (brnch == "") {
				document.getElementById("branchError").innerHTML = "Student Branch Should Not be Null";
				frm.branch.focus();
				return false;
			}
			//to check mobile number is null or not
			if (mobile == "") {
				document.getElementById("mobError").innerHTML = "Mobile Number Should Not be Null";
				frm.mob.focus();
				return false;
			}
			//to check mob is number or not(ie.alphabet)
			else if(isNaN(mobile)){
				document.getElementById("mobError").innerHTML="Mobile Number Must Not Be Alphabet";
				frm.mob.focus();
				return false;
			}
			return true;
		}
	</script>

</body>
</html>