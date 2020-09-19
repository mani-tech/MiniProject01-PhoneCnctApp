<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to PhoneBook App</h1>
<font color='green'>${successMsg}</font>
<font color='red'>${failedMsg}</font>
<font color='blue'>${updateMsg}</font>


<form:form action="saveContact" method="POST" modelAttribute="contact">
<table>
<tr>
	<td><label for="name">Enter Name</label></td>
	<td><form:input type="text" path="name" placeholder="Enter Name"></form:input></td>
	<form:hidden path="cid"/>
</tr>
<tr>
	<td><label for="email">Enter Email</label></td>
	<td><form:input type="email" path="email" placeholder="Enter EmailId"></form:input></td>
</tr>
<tr>
	<td><label for="phoneNo">Enter PhoneNumber</label></td>
	<td><form:input type="number" path="phoneNo"></form:input></td>
</tr>
</table>
<input type="submit" value="Create">
</form:form>
<a href="viewAllCnct">View All Contacts</a>
</body>
</html>