<jsp:include page="Header.jsp"></jsp:include>
<body>
	<form action="perform_login" method="post">
		<center>
			<h1>
				<b>Login form</b>
			</h1>
		</center>
		<div class="form-group">
			<div class="container">
				<div class="jumbotron">

					<div class="form-group col-md-8">
						<label>User Name:</label> <input type="text" name="username"
							id="username" placeholder="Enter Username" class="form-control" />
					</div>
					<div class="form-group col-md-8">
						<label>Password</label> <input type="password" name="password"
							id="pswd" placeholder="Enter Password" class="form-control" />
					</div>
					<div class="col-sm-12">
						<input type="submit" value="login" /><br />

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<jsp:include page="Footer.jsp"></jsp:include>