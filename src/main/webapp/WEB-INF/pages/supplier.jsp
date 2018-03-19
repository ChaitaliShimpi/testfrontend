<jsp:include page="Header.jsp"></jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.jumbotron {
	background-color: tomato;
}
</style>
<body>
<center><h2>Supplier</h2></center>

	<form:form action="savesupplier" method="post"
		modelAttribute="supplier">
		<div class="container">
			<div class="jumbotron">
				<div hidden class="form-group">
					<label for="suppId">ID:</label>
					<form:input path="suppId" type="suppId" class="form-control" placeholder="Enter Name"
						Id="suppId"></form:input>
				</div>

				<div class="form-group">
					<label for="suppName">NAME:</label>
					<form:input path="suppName" type="suppName" class="form-control" placeholder="Enter Name"
						ID="suppName"></form:input>
				</div>
				<div class="form-group">
					<label for="suppDesc">Description</label>
					<form:input path="suppDesc" type="text" class="form-control" placeholder="Enter Description"
						ID="suppDesc"></form:input>
				</div>
				<input type="submit" value="Submit" /> <input type="reset"
					value="Reset" />
			</div>
		</div>
	</form:form>
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<th>Supplier Id</th>
				<th>Supplier Name</th>
				<th>Supplier Description</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${supplist}" var="suppitem">
				<tr>
					<td>${suppitem.suppId}</td>
					<td>${suppitem.suppName}</td>
					<td>${suppitem.suppDesc}</td>
					<td><a href="updatesupplier${suppitem.suppId}"><b>Update</b></a></td>
					<td><a href="deletesupplier${suppitem.suppId}"><b>Delete</b></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>