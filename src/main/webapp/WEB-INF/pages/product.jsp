<jsp:include page="Header.jsp"></jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.jumbotron {
	background-color: tomato;
}
</style>
<body>
	<center>
		<h2>Product</h2>
	</center>
	<form:form action="saveproduct" method="post"
		enctype="multipart/form-data" modelAttribute="product"
		class="form-horizontal">
		<div class="container">
			<div class="jumbotron">

				<div class="form-group col-lg-12">
					<form:label path="prodId" class="control-label col-lg-5">Product Id</form:label>
					<form:input path="prodId" class="form-control" readonly="true" />
					<div class="col-lg-8"></div>
				</div>

				<div class="form-group col-lg-12">
					<form:label path="prodName" class="control-label col-lg-5">Product Name</form:label>
					<form:input path="prodName" class="form-control"
						placeholder="Enter Product Name" />
					<div class="col-lg-7"></div>
				</div>

				<div class="form-group col-lg-12">
					<form:label path="prodDesc" class="control-label col-lg-5">Product Description</form:label>
					<form:input path="prodDesc" class="form-control"
						placeholder="Enter Product Description" />
					<div class="col-lg-7"></div>
				</div>

				<div class="form-group ">
					<form:label path="price" class="control-label col-lg-8">Price</form:label>
					<div class="col-lg-7 input-group">
						<span class="input-group-addon"></span>
						<form:input path="price" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<form:label path="catid" class="control-label col-lg-5">Category Name</form:label>
					<div class="col-lg-7">
						<form:select path="catid">
							<form:option value="0">--select--</form:option>
							<c:forEach var="catitem" items="${catlist}">
								<form:option value="${catitem.catid}" label="${catitem.catname}" />
							</c:forEach>
						</form:select>
					</div>

					<div class="form-group">
						<form:label path="suppid" class="control-label col-lg-5">Supplier Name</form:label>
						<div class="col-lg-7">
							<form:select path="suppid">
								<form:option value="0">--select--</form:option>
								<c:forEach var="suppitem" items="${supplist}">
									<form:option value="${suppitem.suppId}"
										label="${suppitem.suppName}" />
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group">
							<form:label path="quantity" class="control-label col-lg-8">Quantity</form:label>
							<div class="col-lg-7">
								<form:input path="quantity" class="form-control" />
							</div>

							<div class="form-group ">
								<form:label path="image" class="control-label col-lg-12">Image</form:label>
								<div class="col-lg-12">
									<form:input type="file" path="image" class="file" />
								</div>
							</div>
							<div class="form-group col-lg-12">
								<center-left> <input type="submit" value="Submit" />
								<input type="reset" value="Reset" class="btn btn-warning" /> </center-left>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>

	<div class="container">
		<form:form>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Product Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>CatId</th>
						<th>SuppId</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<c:forEach items="${prodlist}" var="proditem">
					<tr>
						<td>${proditem.prodId}</td>
						<td>${proditem.prodName}<br /> <img
							src="resources/productimage/${proditem.prodId}.jpg" width="50"
							height="50" /></td>
						<td>${proditem.prodDesc}</td>
						<td>${proditem.catid}</td>
						<td>${proditem.suppid}</td>
						<td>${proditem.quantity}</td>
						<td>${proditem.price}</td>
						<td><a href="updateproduct${proditem.prodId}"><b>Update</b></a></td>
						<td><a href="deleteproduct${proditem.prodId}"><b>Delete</b></a></td>
					</tr>
				</c:forEach>
			</table>
	</div>
	</form:form>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
