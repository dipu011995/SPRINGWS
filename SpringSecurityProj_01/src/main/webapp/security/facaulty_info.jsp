<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    
      <h1 style="color: green;text-align: center">Facaulty Page</h1>
    
    Logged username :: <%=request.getUserPrincipal().getName() %> is Accessed to this Page
    
    <br><br><br>
     <a href="../logout">logout</a>
     <br><br>
    <a href="../index.jsp">Home</a>
    <br><br>
    <a href="admin_info.jsp">Go to Admin Page</a>