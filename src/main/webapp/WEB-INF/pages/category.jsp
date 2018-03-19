<jsp:include page="Header.jsp" />
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.jumbotron {
	background-color: tomato;
}
</style>
<body><center><h2>Category</h2></center>
<form:form method="post" modelAttribute="category" action="savecategory">
	<div class="container">
		<div class="jumbotron">
			<div hidden class="form-group">
				<label for="catid">ID:</label>
				<form:input path="catid" type="id" class="form-control" Id="catid"></form:input>
			</div>

			<div class="form-group">
				<label for="catname">NAME:</label>
				<form:input path="catname" type="name" class="form-control"
					ID="catname" placeholder="Enter Name"></form:input>
			</div>
			<div class="form-group">
				<label for="catDesc">Description</label>
				<form:input path="catDesc" type="text" class="form-control"
					ID="catDesc" placeholder="Enter Description"></form:input>
			</div>
			<input type="submit" value="Submit" /> <input type="Reset"
				value="Reset" />
		</div>
	</div>
</form:form>
<div class="container">

	<form:form>
		<table class="table table-bordered">
			<tr>
				<th>Category ID</th>
				<th>Category Name</th>
				<th>Category Description</th>
				<th>Update</th>
				<th>Delete</th>

			</tr>

			<c:forEach items="${catlist}" var="catitem">
				<tr>
					<td>${catitem.catid}</td>
					<td>${catitem.catname}</td>
					<td>${catitem.catDesc}</td>
					<td><a href="updatecategory${catitem.catid}"
						class="btn btn-seccess"><b>Update</b></a></td>
					<td><a href="deletecategory${catitem.catid}"><b>Delete</b></a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</div></body>
<jsp:include page="Footer.jsp" />