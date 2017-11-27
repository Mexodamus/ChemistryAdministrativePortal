<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ page import="model.User" %>
    
<%
	User user = (User) session.getAttribute("user");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Management </title>
</head>
<body>

<h1> Account Management Page </h1>


<form name=updatePassword action=UpdatePassword method=get> 

  <label>
   		UGA Email: 
   </label>
   <input type=text name=email value = "<%= user.getEmail() %>" readonly /> 
   <br /> 
   <br />
   
   
   <label>
   		Add Or Updated:
   </label>
   <input type=text name=addedOrUpdated value = "<%= user.getAddedOrUpdated() %>" readonly/> 
   <br /> 
   <br /> 

   
   <label>
   		New Password: 
   </label>
   <input type=text name=password value = "New Password Here"/> 
   <br /> 
   <br /> 
 

   
   <input type=submit name=submit value = "Update your password" /> 

</form>




</body>
</html>