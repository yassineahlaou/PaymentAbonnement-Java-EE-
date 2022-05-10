 <%@page import="gestion.Abonne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ResourceBundle" %>
     <%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
   
    <% Abonne user = (Abonne) session.getAttribute("logUser"); 
    String nomCo = user.getNomComplet();
    
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
<div>
 <h1 style="text-align:center; padding-top: 3cm"><%= resourcebundle.getString("pay") %></h1> 
 <button class="btn btn-primary" style="float:right;" ><a href="LogoutServlet" style="color:white">Log Out</a></button>
 </div>
 <div style = "text-align:center; font-size: 30px;"> <c:if test="${!empty error0}"><p style="color:green;"><c:out value="${error0}"/></p></c:if></div>
  
  <form style ="padding-top : 1cm;padding-bottom : 2cm" action="<%=request.getContextPath()%>/loginsuccess" method="post">
  
  
  
  
  
  
   
     <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("user") %></label>
     <input  type="text" class="form-control" name="nomComplet" value = "<%= user.getNomComplet()%>" readonly="readonly" />
     
   </div>
    <div class="mb-3">
    <label  class="form-label"><%= resourcebundle.getString("email") %></label>
     
    <input type="text" class="form-control" name="email" value = "<%= user.getEmail() %>" readonly="readonly" />
    </div>
    
  
   <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("phone") %></label>
     <input type="text" class="form-control" name="phone" value = "<%= user.getPhone() %>" readonly="readonly" />
    </div>
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("amount") %></label>
     <input type="text" class="form-control" name="montant" value = "<%= user.getMontant() %>" readonly="readonly" />
     
   </div>

     <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("card") %></label>
     <input type="text"  class="form-control" name="cardNumber" value ="${sm.a.cardNumber}"/>
     <div><c:if test="${!empty error1}"><p style="color:red;"><c:out value="${error1}"/></p></c:if></div>
     </div>
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("date") %> (MM/YYYY) </label>
     <input type="text" class="form-control" name="dateExpiration" value ="${sm.a.dateExpiration}"/>
     <div><c:if test="${!empty error2}"><p style="color:red;"><c:out value="${error2}"/></p></c:if></div>
     <div> <c:if test="${!empty error3}"><p style="color:red;"><c:out value="${error3}"/></p></c:if></div>
     </div>
     <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("cvv") %>  </label>
     <input type="text" class="form-control" name="cvv" value ="${sm.a.cvv}"/>
     <div><c:if test="${!empty error4}"><p style="color:red;"><c:out value="${error4}"/></p></c:if></div>
    </div>
     <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("solde") %>  </label>
    <input type="text"  class="form-control"  name="solde" value ="${sm.a.solde}"/>
    <div><c:if test="${!empty error5}"><p style="color:red;"><c:out value="${error5}"/></p></c:if></div>
    <div> <c:if test="${!empty error6}"><p style="color:red;"><c:out value="${error6}"/></p></c:if></div>
     </div>
    
   
     
    
     <input class="btn btn-primary" type="submit" value="Valider" name ="action" />
     
    
   
 
  </form>
  </div>
  

 
</body>
</html>