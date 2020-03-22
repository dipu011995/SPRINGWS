<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    
    <h1 style="color: green;text-align: center">Admin Page</h1>
    
    Logged username :: <%=request.getUserPrincipal().getName() %> is Accessed to this Page
    
    <br><br><br>
    <a href="../logout">logout</a>
    <br><br>
    <a href="../index.jsp">Home</a>
    <br><br>
    <a href="facaulty_info.jsp">GO to Facaulty Page</a>