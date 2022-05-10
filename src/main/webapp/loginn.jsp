<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="authentification.Login"%>
  <%@ page import = "java.util.ResourceBundle" %>
   <%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<%
  //Login l = (Login)request.getAttribute("log");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>


<body>
<% ResourceBundle resourcebundle = ResourceBundle.getBundle("i18n.DemoBundle", request.getLocale()); %>
<div class="container">

  <h1 style="text-align:center; padding-top: 3cm"><%= resourcebundle.getString("sign") %></h1>
 
  
  
  
 
 
 
 <form action="loginn" method="post">
  <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("fname") %></label>
    <input type="text"  class="form-control" name="nomComplet">
    
  </div>
  <div class="mb-3">
    <label  class="form-label"><%= resourcebundle.getString("pass") %></label>
    <input type="password" class="form-control" name="password">
  </div>
  
  <input type="submit" class="btn btn-primary"  value=<%= resourcebundle.getString("sign") %>/>
  
  
</form>

 <c:if test="${!empty echec}"><p style="color:red; text-align:center";><c:out value="${echec}"/></p></c:if>
 </div>
 
</body>
</html>