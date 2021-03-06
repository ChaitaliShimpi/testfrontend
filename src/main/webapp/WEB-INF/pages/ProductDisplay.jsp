<jsp:include page="Header.jsp"></jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<div class="container">
<center><h2>Products List</h2></center>
<div class="jumbotron">
	<table class="table table-bordered">
		<thead><tr><th>ID</th>
				<th>Product</th>
				<th>Description</th>
				<th>Category</th>
				<th>Suppliers</th>
				<th>Quantity</th>
				<th>Price</th></tr>
				</thead>
		<c:forEach items="${prodlist}" var="proditem">
			<tr>
				<td><b>${proditem.prodId}</b></td>
				<td>
				<a href="ProductDescription${proditem.prodId}"> 
				${proditem.prodName}<br/><br/>
				<img src="resources/productimage/${proditem.prodId}.jpg" width="200"
						height="200" /></a></td>
				<td>${proditem.prodDesc}</td>
				<td>${proditem.catid}</td>
				<td>${proditem.suppid}</td>
				<td>${proditem.quantity}</td>
				<td>${proditem.price}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
<jsp:include page="Footer.jsp"></jsp:include>