<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<div id="table root"></div>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>City</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${allemployees}">
				<tr>
					<td>${customer.emp_id}</td>
					<td>${customer.ename}</td>
					<td>${customer.city}</td>
					<td>${customer.salary}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>