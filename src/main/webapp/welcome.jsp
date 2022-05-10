<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.ResourceBundle" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css">
</head>
<body class = "wel">
<% ResourceBundle resourcebundle = ResourceBundle.getBundle("i18n.DemoBundle", request.getLocale()); %>
<div class = "tit"><strong><%= resourcebundle.getString("Bienvenue") %></strong> <img src =<%=resourcebundle.getString("flag") %> width = 22 heigth = 14></div>
<div class ="div1">=><%= resourcebundle.getString("admin1") %>: <button><a href="loginn.jsp">Espace Admin</a></button> <%= resourcebundle.getString("admin2") %>.</div>
<div class ="div1">=><%= resourcebundle.getString("user1") %> : <button><a href="inscription.jsp">Espace Client</a></button> </div>
</body>
</html>