<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dog Entry</title>
</head>
<body>

<form action = "editDogServlet" method="post">
Store: <input type ="text" name = "Breed" value=
"${itemToEdit.breed}">
Item: <input type = "text" name = "Name" value= "${itemToEdit.name}">
<input type = "hidden" name = "ID" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Dog">
</form>

</body>
</html>