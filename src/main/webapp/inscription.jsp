<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
    <%@ page import = "java.util.ResourceBundle" %>
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
  <h1 style="text-align:center; padding-top: 3cm"><%= resourcebundle.getString("form") %></h1>
  <div><c:if test="${!empty error0}"><p style="color:red;"><c:out value="${error0}"/></p></c:if></div>
  <form action="<%=request.getContextPath()%>/inscription" method="post">
  <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("fname") %></label>
    <input type="text"  class="form-control" name="nomComplet">
	<div> <c:if test="${!empty error1}"><p style="color:red;"><c:out value="${error1}"/></p></c:if></div>    
  </div>
  <div class="mb-3">
    <label  class="form-label"><%= resourcebundle.getString("email") %></label>
    <input type="text" class="form-control" name="email">
<div> <c:if test="${!empty error2}"><p style="color:red;"><c:out value="${error2}"/></p></c:if></div>  </div>
  <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("pass") %></label>
    <input type="password"  class="form-control" name="password">
    <div><c:if test="${!empty error3}"><p style="color:red;"><c:out value="${error3}"/></p></c:if></div>
    
  </div>
  <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("phone") %></label>
    <input type="text"  class="form-control" name="phone">
    <div><c:if test="${!empty error4}"><p style="color:red;"><c:out value="${error4}"/></p></c:if></div>
    
  </div>
  
  <input type="submit" class="btn btn-primary"  value="Sign In" name ="action" />
  <input type="button" class="btn btn-primary"  onclick="location.href='loginn.jsp';"  value=<%= resourcebundle.getString("sign") %> />
</form>
  
  
 </div>
 
 

</body>
</html>