<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>The Faceport</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
	<b> <nav
			class="navbar navbar-expand-md bg-secondary navbar-dark">
		<a class="navbar-brand" href="home">The Faceport</a>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
				<c:choose>
					<c:when test="${role=='ROLE_USER'}">
						<li class="nav-item"><a class="nav-link" href="cart">Cart</a></li>
						<li class="nav-item"><a class="nav-link"
							href="ProductDisplay">ProductDisplay</a></li>
					</c:when>
					<c:when test="${role=='ROLE_ADMIN'}">
						<li class="nav-item"><a class="nav-link" href="product">Product</a></li>
						<li class="nav-item"><a class="nav-link" href="supplier">Supplier</a></li>
						<li class="nav-item"><a class="nav-link" href="category">Category</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${loggedIn==true}">
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:otherwise>
				</c:choose>
				<c:if test="${empty loggedIn}">
					<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
				</c:if>
				
			</ul>
		</div>
		</nav></b>
	<br>