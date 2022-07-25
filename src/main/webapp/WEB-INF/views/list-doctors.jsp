<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
<div id="table root"></div>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Speciality</th>
				<th>City</th>
				<th>Phone_no</th>
				<th>Standard fees</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="doctors" items="${alldoctor}">
				<tr>
					<td>${doctors.doc_id}</td>
					<td>${doctors.doc_name}</td>
					<td>${doctors.dob}</td>
					<td>${doctors.speciality}</td>
					<td>${doctors.city}</td>
					<td>${doctors.phone_no}</td>
					<td>${doctors.standard_fees}</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>