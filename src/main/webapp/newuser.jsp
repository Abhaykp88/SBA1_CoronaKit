<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-New User(user)</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr />

	<form action="${pageContext.request.contextPath}/user" method="post" style="background-color:powderblue;">
	<h2>Add New User</h2>
		<div>
			<div>
				<label>Name</label>
			</div>
			<div>
				<input type="text" id="loginid" name="personName" required>
			</div>
		</div>
		<div>
			<div>
				<label>Email</label>
			</div>
			<div>
				<input type="email" id="email" name="email" required>
			</div>
		</div>
		<div>
			<div>
				<label>contactNumber</label>
			</div>
			<div>
				<input type="text" id="contactNumber" name="contactNumber" required>
			</div>
		</div>
		</br>
		<div>

			<div>
			<input type="hidden" name="action" value="insertuser" >
			 <input type="submit" value="save">
			</div>
		</div>
	</form>

	<hr />
	<jsp:include page="footer.jsp" />
</body>

</html>