<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

	<!-- Favicons -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/templates/public/img/favicon.ico">
	<!-- Fontawesome css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/font-awesome.min.css">
	<!-- Ionicons css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/ionicons.min.css">
	<!-- linearicons css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/linearicons.css">
	<!-- Nice select css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/nice-select.css">
	<!-- Jquery fancybox css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/jquery.fancybox.css">
	<!-- Jquery ui price slider css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/jquery-ui.min.css">
	<!-- Meanmenu css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/meanmenu.min.css">
	<!-- Nivo slider css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/nivo-slider.css">
	<!-- Owl carousel css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/owl.carousel.min.css">
	<!-- Bootstrap css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/bootstrap.min.css">
	<!-- Custom css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/default.css">
	<!-- Main css -->
	<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/style.css">--%>
	<!-- Responsive css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/responsive.css">

	<!-- Modernizer js -->
	<script src="<%=request.getContextPath()%>/templates/public/js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Truemart</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
	<!-- Bootstrap -->

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/slick.css"/>
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/slick-theme.css"/>

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet"
		  href="<%=request.getContextPath()%>/templates/public/CSS/nouislider.min.css"/>

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/CSS/style.css"/>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<!-- HEADER -->
<header>

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO -->
				<div class="col-md-3">
					<div class="header-logo">
						<a href="/" class="logo">
							<img src="<%=request.getContextPath()%>/templates/public/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<form>
							<select class="input-select">
								<option value="0">All Categories</option>
							</select>
							<input class="input" placeholder="Search here">
							<button class="search-btn">Search</button>
						</form>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">
						<!-- Cart -->
						<div class="dropdown">
							<div class="cart-dropdown">
								<div class="cart-list">
									<div class="product-widget">
										<div class="product-img">
											<img src="/img/product01.png" alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name"><a
													href="<%=request.getContextPath()%>/view/public/product.jsp">product
												name goes here</a></h3>
											<h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
										</div>
										<button class="delete"><i class="fa fa-close"></i></button>
									</div>

									<div class="product-widget">
										<div class="product-img">
											<img src="<%=request.getContextPath()%>/templates/public/img/product02.png"
												 alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name"><a
													href="<%=request.getContextPath()%>/view/public/product.jsp">product
												name goes here</a></h3>
											<h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
										</div>
										<button class="delete"><i class="fa fa-close"></i></button>
									</div>
								</div>
								<div class="cart-summary">
									<small>3 Item(s) selected</small>
									<h5>SUBTOTAL: $2940.00</h5>
								</div>
								<div class="cart-btns">
									<a href="<%=request.getContextPath()%>/view/public/cart.jsp">View Cart</a>
									<a href="<%=request.getContextPath()%>/view/public/checkout.jsp">Checkout <i
											class="fa fa-arrow-circle-right"></i></a>
								</div>
							</div>
						</div>
						<!-- /Cart -->
						<!-- Wishlist -->
						<div>
							<a href="<%=request.getContextPath()%>/view/public/login.jsp">
								<i class="fa fa-user-o"></i>
								<span>Login | Register</span>
							</a>
						</div>
						<!-- /Wishlist -->

					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

		<div class="breadcrumb-area mt-30 down">
            <div class="container">
                <div class="breadcrumb">
                    <ul class="d-flex align-items-center horizontal ">
                        <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
                        <li><a href="<%=request.getContextPath()%>/view/public/login.jsp" class="active">Login</a></li>
                    </ul>
                </div>
            </div>
            <!-- Container End -->
        </div>


		<div class="login">
			<h3>Login</h3>
			<form action="" method="post">
				<label for="email">Email</label>
				<input type="text" id="email" name="email" placeholder="Enter your email address..." />
				<label for="password">Password</label>
				<input type="password" id="password" name="password" placeholder="Password" />
				<label><a href="#">Forgot password?</a></label>
				<input type="submit" id="submit" name="submit" value="LOGIN"/>
			</form>
			<p>Don't have account? <a href="/register">Sign Up</a></p>
		</div>
<%@include file="/templates/public/inc/footer.jsp"%>