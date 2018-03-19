<jsp:include page="Header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.jumbotron {
	background-color: tomato;
}
</style>
<body>
	<div class="container">
		<div class="jumbotron">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Cart Item ID</th>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>Delete</th>
					</tr>
				</thead>
				<c:forEach items="${cart}" var="c">
					<tr>
						<td>${c.cartId}</td>
						<td><c:forEach items="${prod}" var="p">
								<c:if test="${p.key==c.prodId}">${p.value}</c:if>
							</c:forEach></td>
						<td>${c.quantity}</td>
						<td>${c.subtotal}</td>
						<td><a href="DeleteCartItem${c.cartId}">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td>Total</td>
					<td></td>
					<td>${quantity}</td>
					<td>${price}</td>
				</tr>
				<tr>
					<td><a href="Pay"><b>Buy Now!</b></a></td>
				</tr>
			</table>
		</div>
	</div>
</body>

<jsp:include page="Footer.jsp"></jsp:include>