<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title>
<script>
function deletepopup()
	{
	return confirm("Are you sure want to delete the record?");
	}
</script>
</head>
<body>
<h1>Welcome to View All contacts</h1>
<font color="pink">${deleteMsg}</font><br>
<a href="/">+Add new Contact</a>
<table border="1">
<tr>
		<th>Name</th>
		<th>Email Id</th>
		<th>Phone No</th>
		<th>Action</th>
</tr>
<c:forEach items="${contact }" var="contacts">
<tr>
		<td>${contacts.name }</td>
		<td>${contacts.email }</td>
		<td>${contacts.phoneNo }</td>
		<td><a href="editContact?cid=${contacts.cid }">Edit</a>
		 <a href="deleteContact?cid=${contacts.cid }" onclick="return deletepopup()">Delete</a></td>
	
</tr>
</c:forEach>

</table>
</body>
</html>