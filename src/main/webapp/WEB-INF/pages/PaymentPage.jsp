<jsp:include page="Header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
					</tr>
				</thead>
				<c:forEach items="${cartItems}" var="cartItem">
					<tr>
						<td>${cartItem.cartId}</td>
						<td><c:forEach items="${prodItems}" var="prodItem">
								<c:if test="${prodItem.key==cartItem.prodId}">
										${prodItem.value}
									</c:if>
							</c:forEach></td>
						<td>${cartItem.quantity}</td>
						<td>${cartItem.subtotal}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>Total</td>
					<td></td>
					<td>${quantity}</td>
					<td>${price}</td>
				</tr>
			</table>
			<form action="ConfirmPayment" method="post">
				<label><input type="radio" name="paymode" value="cod">
					Cash on Delivery</label> 
					<label><input type="radio" name="paymode"
					value="cc"> Credit Card</label> 
					<label><input type="radio"
					name="paymode" value="nb"> Net Banking</label><br />
					
					<label>State:</label><br/><input type="text" name="state"><br/><br/>
					
					<label>Pincode:</label><br/><input type="text" name="pincode" maxlength="6"><br/>
					<br/>
					<label>Address:</label><br/><textarea name="shpAddr" placeholder="Enter Shipping Address"></textarea>
					<br />
					<br />
				
				<input type="submit" value="Confirm Payment" />&nbsp; <input
					type="reset" value="Clear" />
			</form>
		</div>
	</div>
</body>
</html>
<jsp:include page="Footer.jsp" />