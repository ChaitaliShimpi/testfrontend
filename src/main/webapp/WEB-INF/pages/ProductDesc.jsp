<jsp:include page="Header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<form action="${pageContext.request.contextPath}/AddToCart"
		method="post">
		<div class="container">
			<h2 class="text-center">Product Description</h2>
			<div class="jumbotron">
				<div class="form-group">
					<div class="hidden">
						<label><b>ID:</b></label> <input type="text" name="prodId"
							value="${proditem.prodId}" readonly="readonly" />
					</div>
					<div>
						<label><b>Name:</b></label> ${proditem.prodName}
					</div>
					<div>
						<label><b>Description:</b></label> ${proditem.prodDesc}
					</div>
					<div>
						<label><b>Price:</b></label> ${proditem.price}
					</div>
					<div>
						<select name="quantity">
							<c:forEach var="i" begin="1" end="${proditem.quantity}">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
						<br />
					</div><br/>
					<div>
						<img height="200" width="200"
							src="resources/productimage/${proditem.prodId}.jpg" />
						<input type="submit" value="Add to Cart" />&nbsp; <input
							type="Reset"/>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<jsp:include page="Footer.jsp"></jsp:include>