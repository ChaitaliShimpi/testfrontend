<jsp:include page="Header.jsp"></jsp:include>


<body>
	<form action="${pageContext.request.contextPath}/AddToCart"
		method="post">
			<div class="form-group">
				<div class="container">
				<center><h2>Product Description</h2></center>
				<div class="jumbotron">
			<center><label>ID:</label> 
				<input type="text" name="prodId"
						value="${proditem.prodId}" readonly="readonly" /><br />
					${proditem.prodName}<br /> ${proditem.prodDesc}<br />
					${proditem.price}<br /> <select name="quantity">
						<option value="1">--Select Quantity--</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select><br /> <br /> 
					<img height="200" width="200" src="resources/productimage/${proditem.prodId}.jpg" /><br /> <br/>
						<input type="submit" value="Add to Cart" />&nbsp; <input type="reset" /><br /></center>
			</div>
			</div>
		</div>
	</form>
</body>
<jsp:include page="Footer.jsp"></jsp:include>