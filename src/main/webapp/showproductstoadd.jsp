<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-All Products(user)</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<hr />
	<h1>Select Products </h1>
	<form action="${pageContext.request.contextPath}/user" method="post" style="background-color:powderblue;">
		<div>
			<div>
				<label>Products</label>
			</div>
			<div>
				<select  name="product" >
				<option>Mask</option>
				<option>Senitizer</option>
				<option>Gloves</option>
				</select>
			</div>
		</div>
		<div>
			<div>
				<label>Quantity</label>
			</div>
			<div>
				<select Id="quantity" name="quantity" onchange=calPrice()>
				<option value="1"> 1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				</select>
			</div>
		</div>
		<div>
			<div>
				<label>Price</label>
			</div>
			<div>
			
				<input type="text" name="price" value="30" id="price">
			</div>
		</div>
		</br>
		<div>

			<div>
			<input type="hidden" name="action" value="placeorder" >
			 <input type="submit" value="Buy Now">
			</div>
		</div>
	</form>
	<hr />
	<jsp:include page="footer.jsp" />
	
	
<script>
function calPrice(){
	var quantit = document.getElementById("quantity").value;
	
	var price = quantit * 30;
	document.getElementById("price").value = price;
}
</script>
	
</body>

</html>