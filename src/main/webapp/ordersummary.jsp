<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Order Summary(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<form action="${pageContext.request.contextPath}/user" method="post">
		<h2 style="color: green;"><strong>Order Placed successfully</strong></h2>
	</form>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>