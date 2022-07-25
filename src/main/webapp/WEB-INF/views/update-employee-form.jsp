<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="updateemp" method="post" modelAttribute="updateemployee">
				<div>
					<label for="emp_id">ID:</label>
					<div>
						<form:input path="emp_id" />
					</div>
				</div>
				<div>
					<label for="ename">Name:</label>
					<div>
						<form:input path="ename" />
					</div>
				</div>
				<div>
					<label for="city">City:</label>
					<div>
						<form:input path="city" />
					</div>
				</div>
				<div>
					<label for="salary">Salary:</label>
					<div>
						<form:input path="salary" />
					</div>
				</div>
				<div>
					<form:button>Update</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>