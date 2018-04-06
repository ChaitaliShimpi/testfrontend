
<jsp:include page="Header.jsp" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
.carousal-item img {
	width: 100%;
	height: 100%;
}
</style>
<body>
<div class="container">
	<div id="demo" class="carousel slide" data-ride="carousel">
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="resources/productimage/DSC_1596-769.jpg" alt="Los Angeles"
					width="1100" height="500">
				<div class="carousel-caption">
					<h1><b>Upto 30% OFF!!!</b></h1>	
				</div>
			</div>
			<div class="carousel-item">
				<img src="resources/productimage/381699739-1-1.jpg" alt="New York"
					width="1100" height="500">
				<div class="carousel-caption">
					<h3>New York</h3>
				</div></div>
				<div class="carousel-item">
				<img src="resources/productimage/timthumb.png" alt="chicago"
					width="1100" height="500">
				<div class="carousel-caption">
					<h3>New York</h3>
				</div>
			</div>
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> 
		<span class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
</div></div></body>
<jsp:include page="Footer.jsp"></jsp:include>