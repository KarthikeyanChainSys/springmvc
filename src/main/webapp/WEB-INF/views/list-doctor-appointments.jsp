<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Appointments</title>
</head>
<body>
<div id="root">
		<div id="docform">
			<form:form action="" method="post" modelAttribute="getdoc">
				<div>
					<label for="doc_id">ID:</label>
					<div>
						<form:input path="doc_id" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="dname">Name:</label>
					<div>
						<form:input path="doc_name" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="dob">DOB:</label>
					<div>
						<form:input path="dob" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="speciality">Speciality:</label>
					<div>
						<form:input path="speciality" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="city">City:</label>
					<div>
						<form:input path="city" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="phone_no">Phone_no:</label>
					<div>
						<form:input path="phone_no" readonly="true"/>
					</div>
				</div>
				<div>
					<label for="standard_fees">Standard_fees:</label>
					<div>
						<form:input path="standard_fees" readonly="true"/>
					</div>
				</div>
			</form:form>
		</div>
		<div id="applist">
			<table>
		<thead>
			<tr>
				<th>Appointment Id</th>
				<th>Appointment Date</th>
				<th>Doctor Id</th>
				<th>Patient Name</th>
				<th>Fees</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="app" items="${applist}">
				<tr>
					<td>${app.app_id}</td>
					<td>${app.app_date}</td>
					<td>${app.doc_id}</td>
					<td>${app.patient_name}</td>
					<td>${app.fees_collected}</td>
					<td>${app.fees_catogory}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
	</div>
</body>
</html>