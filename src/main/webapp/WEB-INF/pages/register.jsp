<jsp:include page="Header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.jumbotron {
	background-color: tomato;
}
</style>
<body>
<center><h2>Register</h2></center>
<div class="container">
<div class="jumbotron">
	<form:form method="post" action="saveUser" modelAttribute="user">
	<div class="form-group col-lg-12">
	<form:label path="username" class="control-label col-lg-8">Username</form:label>
	<form:input path="username" placeholder="Enter Username"  class="form-control" />
	</div>
	<div class="form-group col-lg-12">
	<form:label path="password" class="control-label col-lg-8">Password</form:label>
	<form:input path="password"  placeholder="Enter Password" class="form-control" />
	</div>
	<div class="form-group col-lg-12">
	<form:label path="email" class="control-label col-lg-8">Email</form:label>
	<form:input path="email"  placeholder="Enter Email" class="form-control" />
	</div>
	<div class="form-group col-lg-12">
	<form:label path="phone"  class="control-label col-lg-8">Phone</form:label>
	<form:input path="phone" placeholder="Enter Phone" class="form-control" />
	</div>
	<div class="form-group col-lg-12">
	<form:label path="address" class="control-label col-lg-8">Address</form:label>
	<form:input path="address" placeholder="Enter Address" class="form-control" />
	</div>
	<center><input type="submit" value="Register"/></center>
	</form:form></div></div>
	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
	<jsp:include page="Footer.jsp" />