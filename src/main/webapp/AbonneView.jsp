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
<script type="text/javascript">
function confirmm(url)
{
	var res = confirm("Are you sure?");
	if (res == true)
		{
		document.location = url;
		}
	}
</script>
</head>
<body>
<% ResourceBundle resourcebundle = ResourceBundle.getBundle("i18n.DemoBundle", request.getLocale()); %>
<div class="container" style="margin-bottom:2cm">

<div style="padding-top:1cm; ">
<button class="btn btn-primary" style="float:right;" ><a href="loginn.jsp" style="color:white">Log Out</a></button>
  
  <form action="AbonneView" method="post">
  
  
     <label  class="form-label"><strong><%= resourcebundle.getString("key") %></strong></label>
     <input type="text"  name="keyword" value = "${sm.keyword}"/><!-- we added value to keep the input shown -->
   <input class="btn btn-primary"  type="submit" value="Search" name ="action" />
   
 
  </form>
  </div>
  <div style="padding-top:1cm; ">
  <table class="table table-striped" >
  <tr>
  <th><%= resourcebundle.getString("fname") %></th>
  <th><%= resourcebundle.getString("email") %></th>
  <th><%= resourcebundle.getString("pass") %> </th>
  <th><%= resourcebundle.getString("phone") %> </th>
  <th><%= resourcebundle.getString("amount") %> </th>
  <th><%= resourcebundle.getString("card") %> </th>
  <th><%= resourcebundle.getString("date") %> </th>
  <th><%= resourcebundle.getString("cvv") %> </th>
  <th><%= resourcebundle.getString("solde") %> </th>
  </tr>
  <!-- en utilise la balise jstl , plus facile -->
  <c:forEach items = "${sm.abonnes }"  var ="bo">
  <tr>
  <td>${bo.nomComplet}</td>
  <td>${bo.email}</td>
  <td>${bo.password}</td>
  <td>${bo.phone}</td>
  <td>${bo.montant}</td>
  <td>${bo.cardNumber}</td>
  <td>${bo.dateExpiration}</td>
  <td>${bo.cvv}</td>
   <td>${bo.solde}</td>
  
  <td>
  	 <a href="AbonneView?action=Delete&nomComplet=${bo.nomComplet}"><%= resourcebundle.getString("delete") %></a>
  	 
  	
  </td>
  <td>
  	 <a href="AbonneView?action=Edit&nomComplet=${bo.nomComplet}"><%= resourcebundle.getString("edit") %></a>
  	
  </td>
  </tr>
    	
  </c:forEach>
  </table>
  </div>
  <hr style="border-top: 1px solid black; margin-top:2cm">
  
  <div style="padding-top:1cm">
  
  <form action="<%=request.getContextPath()%>/AbonneView" method="post">
  <input type="hidden" value="${sm.mode}" name="mode">
  
  
  
  
    
    <c:if test ="${sm.mode == 'add' }">
  
  <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("fname") %></label>
     <input type="text" class="form-control" name="nomComplet" value ="${sm.a.nomComplet}"/>
     <div><c:if test="${!empty error1}"><p style="color:red;"><c:out value="${error1}"/></p></c:if></div>
   </div>
    </c:if>
    <c:if test ="${sm.mode == 'edit' }">
  
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("fname") %></label>
     <input class="form-control" readonly="readonly" name="nomComplet" value ="${sm.a.nomComplet}"/>
    </div>
    </c:if>
    
    
    
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("email") %></label>
     <input type="text"  class="form-control" name="email" value ="${sm.a.email}"/>
    <div><c:if test="${!empty error2}"><p style="color:red;"><c:out value="${error2}"/></p></c:if></div>
    </div>
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("pass") %></label>
    <input type="text" class="form-control" name="password" value ="${sm.a.password}"/></td>
     <div> <c:if test="${!empty error3}"><p style="color:red;"><c:out value="${error3}"/></p></c:if></div>
   </div>
    <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("phone") %></label>
     <input type="text" class="form-control" name="phone" value ="${sm.a.phone}"/>
     <div> <c:if test="${!empty error4}"><p style="color:red;"><c:out value="${error4}"/></p></c:if></div>
    </div>
     <div class="mb-3">
    <label class="form-label"><%= resourcebundle.getString("amount") %></label>
     <input type="text" class="form-control" name="montant" value ="${sm.a.montant}"/>
       <div> <c:if test="${!empty error5}"><p style="color:red;"><c:out value="${error5}"/></p></c:if></div>
     
    </div>
    
     
    
     <input type="submit" class="btn btn-primary" value="Save" name ="action" />
   
  </form>
  </div>
  <div style = "text-align:center; font-size: 30px;">
  
  <c:if test="${!empty success1}"><p style="color:green;"><c:out value="${success1}"/></p></c:if>
  </div>
  <div style = "text-align:center; font-size: 30px;">
    <c:if test="${!empty success2}"><p style="color:green;"><c:out value="${success2}"/></p></c:if>
  </div>
  
  <div style = "text-align : center">
  
  
   </div>
</div>
</body>
</html>