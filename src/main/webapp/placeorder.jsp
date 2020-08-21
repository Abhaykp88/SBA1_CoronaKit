<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<form action="${pageContext.request.contextPath}/user" method="post" style="background-color:powderblue;">
	<h2>Place Order</h2>
	<div>
		<label>Total Amount: <span><strong>${amount}</strong></span></label>
  		<table id=shippingaddress>
  		<tbody>
  		<tr><td>Shipping Address</td></tr>
  		<tr>
  		<td><label>Name: </label>
  		<td><input type=text required></td>
  		</tr>
  		<tr>
  		<td><label>Address line 1: </label>
  		<td><input type=text required></td>
  		</tr>
  		<tr>
  		<td><label>Address line 2: </label>
  		<td><input type=text></td>
  		</tr>
  		<tr>
  		<td><label>Landmark: </label>
  		<td><input type=text></td>
  		</tr>
  		<tr>
  		<td><label>Pincode </label>
  		<td><input type=text required></td>
  		</tr>
  		<tr>
  		<td><label>Contact Number </label>
  		<td><input type=text required></td>
  		</tr>
  		
  		
  		
  		</tbody>
  		</table>
  		<input type="hidden" name="action" value="ordersummary" >
  		<input type="submit" value="Confirm Order"/>
	</div>
</form>
	<hr />
	<jsp:include page="footer.jsp" />
</body>
</html>