<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<table>
		<thead>
			<tr>
				<th>Cart Item ID</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Total</th>
				<th>Delete</th>
			</tr>
		</thead>
		<c:forEach items="${cart}" var="cart">
			<tr>
				<td>${cart.cartId}</td>
				<td><c:forEach items="${proditem}" var="proditem">
						<c:if test="${proditem.key==cart.prodId}">${proditem.value}</c:if>
					</c:forEach></td>
				<td>${cart.quantity}</td>
				<td>${cart.subtotal}</td>
				<td><a href="DeleteCartItem${cart.cartId}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total</td>
			<td></td>
			<td>${quantity}</td>
			<td>${price}</td>
			<td><a href="Pay">Buy Now!</a></td>
		</tr>
		<tr>
	</table>
</body>
</html>